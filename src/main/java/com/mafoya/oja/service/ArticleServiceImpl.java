package com.mafoya.oja.service;

import com.mafoya.oja.dto.ArticleDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Article;
import com.mafoya.oja.repository.ArticleRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto getById(String authorization, String id) {
        ArticleDto articleDto;
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            articleDto = OjaMapper.mapArticleDto(articleOptional.get());
            return articleDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ArticleDto create(String authorization, ArticleDto articleDto) {
        Article article = OjaMapper.mapArticleDo(articleDto);
        articleRepository.save(article);
        return articleDto;
    }

    @Override
    public ArticleDto update(String authorization, ArticleDto articleDto, String id) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            Article article = OjaMapper.mapArticleDo(articleDto);
            article.setId(id);
            articleRepository.save(article);
            return articleDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ArticleDto> getAll(String authorization) {
        List<Article> doList = (List<Article>) articleRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Set<ArticleDto> findByUserId(String authorization,String id) {
        List<Article> doList = (List<Article>) articleRepository.findByUserId(id);
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }
}
