package com.mafoya.oja.service;

import com.mafoya.oja.dto.BlogDto;

import java.util.List;

public interface BlogService {
    BlogDto create(String authorization, BlogDto blogDto);

    BlogDto update(String authorization, BlogDto blogDto, String id);

    BlogDto getById(String authorization, String id);

    List<BlogDto> getAll(String authorization);

    void delete(String authorization, String id);
}
