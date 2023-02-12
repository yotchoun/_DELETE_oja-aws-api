package com.mafoya.oja.service;

import com.mafoya.oja.dto.ArticleDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Article;
import com.mafoya.oja.model.UserAddress;
import com.mafoya.oja.repository.UserAddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserAddressServiceImpl  implements UserAddressService {

    private final UserAddressRepository userAddressRepository;

    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
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
}

