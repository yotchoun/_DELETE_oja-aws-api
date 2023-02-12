package com.mafoya.oja.service;

import com.mafoya.oja.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto create(String authorization, CategoryDto categoryDto);

    CategoryDto update(String authorization, CategoryDto categoryDto, String id);

    CategoryDto getById(String authorization, String id);

    List<CategoryDto> getAll(String authorization);

    void delete(String authorization, String id);
}
