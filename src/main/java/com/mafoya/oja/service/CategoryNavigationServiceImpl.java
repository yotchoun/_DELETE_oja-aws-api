package com.mafoya.oja.service;


import com.mafoya.oja.dto.CategoryItemDto;
import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.CategoryItem;
import com.mafoya.oja.model.CategoryNavigation;
import com.mafoya.oja.repository.CategoryItemRepository;
import com.mafoya.oja.repository.CategoryNavigationRepository;

import java.util.*;
import java.util.stream.Collectors;

public class CategoryNavigationServiceImpl implements CategoryNavigationService {

    private final CategoryNavigationRepository categoryNavigationRepository;

    private final CategoryItemRepository categoryItemRepository;

    public CategoryNavigationServiceImpl(CategoryNavigationRepository categoryNavigationRepository, CategoryItemRepository categoryItemRepository) {
        this.categoryNavigationRepository = categoryNavigationRepository;
        this.categoryItemRepository = categoryItemRepository;
    }

    @Override
    public CategoryNavigationDto getById(String authorization, String id) {

        CategoryNavigationDto categoryNavigationDto;
        Optional<CategoryNavigation> categoryNavigationOptional = categoryNavigationRepository.findById(id);
        if (categoryNavigationOptional.isPresent()) {
            Set<CategoryItem> categoryItemDo = categoryItemRepository.findByCategoryNavigationId(id);
            Set<CategoryItemDto> categoryItemDTOs = categoryItemDo.stream().map(OjaMapper::mapCategoryItemDto)
                    .collect(Collectors.toCollection(HashSet::new));
            categoryNavigationDto = OjaMapper.mapCategoryNavigationDto(categoryNavigationOptional.get());
            categoryNavigationDto.setCategoryItem(categoryItemDTOs);
            return categoryNavigationDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public CategoryNavigationDto create(String authorization, CategoryNavigationDto categoryNavigationDto) {

        CategoryNavigation categoryNavigation = OjaMapper.mapCategoryNavigationDo(categoryNavigationDto);
        categoryNavigationRepository.save(categoryNavigation);
        return categoryNavigationDto;
    }

    @Override
    public CategoryNavigationDto update(String authorization, CategoryNavigationDto categoryNavigationDto, String id) {

        Optional<CategoryNavigation> categoryNavigationOptional = categoryNavigationRepository.findById(id);
        if (categoryNavigationOptional.isPresent()) {
            CategoryNavigation categoryNavigationDo = OjaMapper.mapCategoryNavigationDo(categoryNavigationDto);
            categoryNavigationDo.setId(id);
            categoryNavigationRepository.save(categoryNavigationDo);
            return categoryNavigationDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<CategoryNavigationDto> getAll(String authorization) {

        List<CategoryNavigation> doList = (List<CategoryNavigation>) categoryNavigationRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        categoryNavigationRepository.deleteById(id);
    }

}