package com.mafoya.oja.service;


import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.CategoryNavigation;
import com.mafoya.oja.repository.CategoryNavigationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class CategoryNavigationDtoServiceImpl implements CategoryNavigationService {

    private final CategoryNavigationRepository categoryNavigationRepository;

    public CategoryNavigationDtoServiceImpl(CategoryNavigationRepository categoryNavigationRepository) {
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

        List<AtomicReference<CategoryNavigationDto>> dtoList = new ArrayList<>();
        AtomicReference<CategoryNavigationDto> categoryNavigationDto = null;

        List<CategoryNavigation> doList = (List<CategoryNavigation>) categoryNavigationRepository.findAll();

        doList.stream().map(categoryNavigation -> {
            categoryNavigationDto.set(OjaMapper.mapCategoryNavigationDto(categoryNavigation));
            dtoList.add(categoryNavigationDto);
        }).;

    }

    @Override
    public void delete(String authorization, String id) {
        categoryNavigationRepository.deleteById(id);
    }

}