package com.mafoya.oja.service;


import com.mafoya.oja.dto.CategoryNavigationDto;

import java.util.List;
import java.util.Optional;

public interface CategoryNavigationService {

    CategoryNavigationDto create(String authorization, CategoryNavigationDto categoryNavigationDto);

    CategoryNavigationDto update(String authorization, CategoryNavigationDto categoryNavigationDto, String id);

    CategoryNavigationDto getById(String authorization, String id);

    List<CategoryNavigationDto> getAll(String authorization);

    void delete(String authorization, String id);

}
