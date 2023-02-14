package com.mafoya.oja.service;

import com.mafoya.oja.dto.CategoryDto;
import com.mafoya.oja.dto.CategoryItemDto;
import com.mafoya.oja.dto.CategoryParentDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Category;
import com.mafoya.oja.model.CategoryItem;
import com.mafoya.oja.model.CategoryParent;
import com.mafoya.oja.repository.CategoryParentRepository;
import com.mafoya.oja.repository.CategoryRepository;

import java.util.*;
import java.util.stream.Collectors;

public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryParentRepository categoryParentRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryParentRepository categoryParentRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryParentRepository = categoryParentRepository;
    }

    @Override
    public CategoryDto getById(String authorization, String id) {
        CategoryDto categoryDto;
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Set<CategoryParent> categoryParentDo = categoryParentRepository.findByCategoryId(id);
            Set<CategoryParentDto> categoryParentDTOs = categoryParentDo.stream().map(OjaMapper::mapCategoryParentDto)
                    .collect(Collectors.toCollection(HashSet::new));
            categoryDto = OjaMapper.mapCategoryDto(categoryOptional.get());
            categoryDto.setParent(categoryParentDTOs);
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

    @Override
    public Set<CategoryDto> findByForId(String authorization,String id) {
        List<Category> doList = (List<Category>) categoryRepository.findByForId(id);
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<CategoryDto> findByProductId(String authorization,String id) {
        List<Category> doList = (List<Category>) categoryRepository.findByProductId(id);
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

