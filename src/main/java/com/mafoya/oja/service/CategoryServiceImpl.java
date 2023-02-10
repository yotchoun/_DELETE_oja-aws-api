package com.mafoya.oja.service;

import com.mafoya.oja.model.Category;
import com.mafoya.oja.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String authorization, Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(String authorization, Category category, String id) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getById(String authorization, String id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAll(String authorization) {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        categoryRepository.deleteById(id);
    }
}

