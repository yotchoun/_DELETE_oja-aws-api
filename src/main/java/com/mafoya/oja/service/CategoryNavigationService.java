package com.mafoya.oja.service;



import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.model.CategoryNavigation;

import java.util.List;
import java.util.Optional;

public interface CategoryNavigationService {

    CategoryNavigation create(String authorization, CategoryNavigationDto navigationDto);

    CategoryNavigation update(String authorization, CategoryNavigation navigation, String id);

    Optional<CategoryNavigation> getById(String authorization, String id);

    List<CategoryNavigation> getAll(String authorization);

    void delete(String authorization, String id);

}
