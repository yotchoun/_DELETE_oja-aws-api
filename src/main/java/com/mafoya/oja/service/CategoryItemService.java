package com.mafoya.oja.service;

import com.mafoya.oja.model.CategoryItem;

import java.util.List;
import java.util.Optional;

public interface CategoryItemService {
    CategoryItem create(String authorization, CategoryItem categoryItem);

    CategoryItem update(String authorization, CategoryItem categoryItem, String id);

    Optional<CategoryItem> getById(String authorization, String id);

    List<CategoryItem> getAll(String authorization);

    void delete(String authorization, String id);
}
