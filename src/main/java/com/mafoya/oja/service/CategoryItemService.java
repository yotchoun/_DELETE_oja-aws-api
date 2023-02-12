package com.mafoya.oja.service;

import com.mafoya.oja.dto.CategoryItemDto;

import java.util.List;

public interface CategoryItemService {
    CategoryItemDto create(String authorization, CategoryItemDto categoryItemDto);

    CategoryItemDto update(String authorization, CategoryItemDto categoryItemDto, String id);

    CategoryItemDto getById(String authorization, String id);

    List<CategoryItemDto> getAll(String authorization);

    void delete(String authorization, String id);
}
