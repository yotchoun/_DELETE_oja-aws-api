package com.mafoya.oja.service;

import com.mafoya.oja.dto.CategoryParentDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.CategoryParent;
import com.mafoya.oja.model.CategoryParent;
import com.mafoya.oja.repository.CategoryParentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryParentServiceImpl  implements CategoryParentService {

    private final CategoryParentRepository categoryParentRepository;

    public CategoryParentServiceImpl(CategoryParentRepository categoryParentRepository) {
        this.categoryParentRepository = categoryParentRepository;
    }

    @Override
    public CategoryParentDto getById(String authorization, String id) {
        CategoryParentDto categoryParentDto;
        Optional<CategoryParent> categoryParentOptional = categoryParentRepository.findById(id);
        if (categoryParentOptional.isPresent()) {
            categoryParentDto = OjaMapper.mapCategoryParentDto(categoryParentOptional.get());
            return categoryParentDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public CategoryParentDto create(String authorization, CategoryParentDto categoryParentDto) {
        CategoryParent categoryParent = OjaMapper.mapCategoryParentDo(categoryParentDto);
        categoryParentRepository.save(categoryParent);
        return categoryParentDto;
    }

    @Override
    public CategoryParentDto update(String authorization, CategoryParentDto categoryParentDto, String id) {
        Optional<CategoryParent> categoryParentOptional = categoryParentRepository.findById(id);
        if (categoryParentOptional.isPresent()) {
            CategoryParent categoryParent = OjaMapper.mapCategoryParentDo(categoryParentDto);
            categoryParent.setId(id);
            categoryParentRepository.save(categoryParent);
            return categoryParentDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<CategoryParentDto> getAll(String authorization) {
        List<CategoryParent> doList = (List<CategoryParent>) categoryParentRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        categoryParentRepository.deleteById(id);
    }
}

