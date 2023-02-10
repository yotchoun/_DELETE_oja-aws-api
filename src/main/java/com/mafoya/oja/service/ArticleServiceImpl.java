package com.mafoya.oja.service;

import com.mafoya.oja.model.Article;
import com.mafoya.oja.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article create(String authorization, Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article update(String authorization, Article article, String id) {
        return articleRepository.save(article);
    }

    @Override
    public Optional<Article> getById(String authorization, String id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> getAll(String authorization) {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        articleRepository.deleteById(id);
    }
}
