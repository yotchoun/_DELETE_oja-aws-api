package com.mafoya.oja.service;

import com.mafoya.oja.model.CategoryItem;
import com.mafoya.oja.repository.CategoryItemRepository;

import java.util.List;
import java.util.Optional;

public class CategoryItemServiceImpl  implements CategoryItemService {

    private final CategoryItemRepository categoryItemRepository;

    public CategoryItemServiceImpl(CategoryItemRepository categoryItemRepository) {
        this.categoryItemRepository = categoryItemRepository;
    }

    @Override
    public CategoryItem create(String authorization, CategoryItem categoryItem) {
        return categoryItemRepository.save(categoryItem);
    }

    @Override
    public CategoryItem update(String authorization, CategoryItem categoryItem, String id) {
        return categoryItemRepository.save(categoryItem);
    }

    @Override
    public Optional<CategoryItem> getById(String authorization, String id) {
        return categoryItemRepository.findById(id);
    }

    @Override
    public List<CategoryItem> getAll(String authorization) {
        return (List<CategoryItem>) categoryItemRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        categoryItemRepository.deleteById(id);
    }
}

