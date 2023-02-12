package com.mafoya.oja.service;


import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.CategoryNavigation;
import com.mafoya.oja.repository.CategoryNavigationRepository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class CategoryNavigationServiceImpl implements CategoryNavigationService {

    private final CategoryNavigationRepository categoryNavigationRepository;

    public CategoryNavigationServiceImpl(CategoryNavigationRepository categoryNavigationRepository) {
        this.categoryNavigationRepository = categoryNavigationRepository;
    }

    @Override
    public CategoryNavigationDto create(String authorization, CategoryNavigationDto categoryNavigationDto) {

        CategoryNavigation categoryNavigationDo = OjaMapper.mapCategoryNavigationDo(categoryNavigationDto);
        categoryNavigationRepository.save(categoryNavigationDo);
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
    public CategoryNavigationDto getById(String authorization, String id) {

        Optional<CategoryNavigation> categoryNavigationOptional = categoryNavigationRepository.findById(id);
        if (categoryNavigationOptional.isPresent()) {
            return OjaMapper.mapCategoryNavigationDto(categoryNavigationOptional.get());
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }

    @Override
    public List<CategoryNavigationDto> getAll(String authorization) {

        List<CategoryNavigation> doList = (List<CategoryNavigation>) categoryNavigationRepository.findAll();
        return doList.stream().map(categoryNavigation -> OjaMapper.mapCategoryNavigationDto(categoryNavigation))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        categoryNavigationRepository.deleteById(id);
    }

}