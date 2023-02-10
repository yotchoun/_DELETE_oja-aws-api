package com.mafoya.oja.service;

import com.mafoya.oja.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category create(String authorization, Category category);

    Category update(String authorization, Category category, String id);

    Optional<Category> getById(String authorization, String id);

    List<Category> getAll(String authorization);

    void delete(String authorization, String id);
}
