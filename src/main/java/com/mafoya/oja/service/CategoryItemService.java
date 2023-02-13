package com.mafoya.oja.service;

import com.mafoya.oja.dto.CategoryItemDto;

import java.util.List;
import java.util.Set;

public interface CategoryItemService {
    CategoryItemDto create(String authorization, CategoryItemDto categoryItemDto);

    CategoryItemDto update(String authorization, CategoryItemDto categoryItemDto, String id);

    CategoryItemDto getById(String authorization, String id);

    List<CategoryItemDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<CategoryItemDto> findByCategoryNavigationId(String authorization,String id);

    Set<CategoryItemDto> findByCategoryItemId(String authorization,String id);
}
