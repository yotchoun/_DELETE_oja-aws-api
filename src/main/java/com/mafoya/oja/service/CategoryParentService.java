package com.mafoya.oja.service;

import com.mafoya.oja.model.CategoryParent;

import java.util.List;
import java.util.Optional;

public interface CategoryParentService {
    CategoryParent create(String authorization, CategoryParent categoryParent);

    CategoryParent update(String authorization, CategoryParent categoryParent, String id);

    Optional<CategoryParent> getById(String authorization, String id);

    List<CategoryParent> getAll(String authorization);

    void delete(String authorization, String id);
}
