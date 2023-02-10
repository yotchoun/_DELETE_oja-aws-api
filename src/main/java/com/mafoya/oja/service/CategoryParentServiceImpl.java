package com.mafoya.oja.service;

import com.mafoya.oja.model.CategoryParent;
import com.mafoya.oja.repository.CategoryParentRepository;

import java.util.List;
import java.util.Optional;

public class CategoryParentServiceImpl  implements CategoryParentService {

    private final CategoryParentRepository categoryParentRepository;

    public CategoryParentServiceImpl(CategoryParentRepository categoryParentRepository) {
        this.categoryParentRepository = categoryParentRepository;
    }

    @Override
    public CategoryParent create(String authorization, CategoryParent categoryParent) {
        return categoryParentRepository.save(categoryParent);
    }

    @Override
    public CategoryParent update(String authorization, CategoryParent categoryParent, String id) {
        return categoryParentRepository.save(categoryParent);
    }

    @Override
    public Optional<CategoryParent> getById(String authorization, String id) {
        return categoryParentRepository.findById(id);
    }

    @Override
    public List<CategoryParent> getAll(String authorization) {
        return (List<CategoryParent>) categoryParentRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        categoryParentRepository.deleteById(id);
    }
}

