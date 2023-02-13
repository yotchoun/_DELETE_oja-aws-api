package com.mafoya.oja.service;


import com.mafoya.oja.dto.ArticleDto;

import java.util.List;
import java.util.Set;

public interface ArticleService {
    ArticleDto create(String authorization, ArticleDto articleDto);

    ArticleDto update(String authorization, ArticleDto articleDto, String id);

    ArticleDto getById(String authorization, String id);

    List<ArticleDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<ArticleDto> findByUserId(String authorization,String id);
}
