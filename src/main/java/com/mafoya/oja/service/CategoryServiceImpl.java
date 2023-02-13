package com.mafoya.oja.service;

import com.mafoya.oja.dto.CategoryDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Category;
import com.mafoya.oja.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto getById(String authorization, String id) {
        CategoryDto categoryDto;
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryDto = OjaMapper.mapCategoryDto(categoryOptional.get());
            return categoryDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public CategoryDto create(String authorization, CategoryDto categoryDto) {
        Category category = OjaMapper.mapCategoryDo(categoryDto);
        categoryRepository.save(category);
        return categoryDto;
    }

    @Override
    public CategoryDto update(String authorization, CategoryDto categoryDto, String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = OjaMapper.mapCategoryDo(categoryDto);
            category.setId(id);
            categoryRepository.save(category);
            return categoryDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<CategoryDto> getAll(String authorization) {
        List<Category> doList = (List<Category>) categoryRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        categoryRepository.deleteById(id);
    }
}

