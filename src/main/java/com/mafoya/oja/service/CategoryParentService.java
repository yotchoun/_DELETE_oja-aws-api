package com.mafoya.oja.service;

import com.mafoya.oja.dto.CategoryParentDto;

import java.util.List;

public interface CategoryParentService {
    CategoryParentDto create(String authorization, CategoryParentDto categoryParentDto);

    CategoryParentDto update(String authorization, CategoryParentDto categoryParentDto, String id);

    CategoryParentDto getById(String authorization, String id);

    List<CategoryParentDto> getAll(String authorization);

    void delete(String authorization, String id);
}
