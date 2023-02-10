package com.mafoya.oja.service;

import com.mafoya.oja.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Article create(String authorization, Article article);

    Article update(String authorization, Article article, String id);

    Optional<Article> getById(String authorization, String id);

    List<Article> getAll(String authorization);

    void delete(String authorization, String id);
}
