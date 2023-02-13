package com.mafoya.oja.service;

import com.mafoya.oja.dto.CategoryItemDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.CategoryItem;
import com.mafoya.oja.repository.CategoryItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryItemServiceImpl  implements CategoryItemService {


    private final CategoryItemRepository categoryItemRepository;

    public CategoryItemServiceImpl(CategoryItemRepository categoryItemRepository) {
        this.categoryItemRepository = categoryItemRepository;
    }

    @Override
    public CategoryItemDto getById(String authorization, String id) {
        CategoryItemDto categoryItemDto;
        Optional<CategoryItem> categoryItemOptional = categoryItemRepository.findById(id);
        if (categoryItemOptional.isPresent()) {
            categoryItemDto = OjaMapper.mapCategoryItemDto(categoryItemOptional.get());
            return categoryItemDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public CategoryItemDto create(String authorization, CategoryItemDto categoryItemDto) {
        CategoryItem categoryItem = OjaMapper.mapCategoryItemDo(categoryItemDto);
        categoryItemRepository.save(categoryItem);
        return categoryItemDto;
    }

    @Override
    public CategoryItemDto update(String authorization, CategoryItemDto categoryItemDto, String id) {
        Optional<CategoryItem> categoryItemOptional = categoryItemRepository.findById(id);
        if (categoryItemOptional.isPresent()) {
            CategoryItem categoryItem = OjaMapper.mapCategoryItemDo(categoryItemDto);
            categoryItem.setId(id);
            categoryItemRepository.save(categoryItem);
            return categoryItemDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<CategoryItemDto> getAll(String authorization) {
        List<CategoryItem> doList = (List<CategoryItem>) categoryItemRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        categoryItemRepository.deleteById(id);
    }
}

