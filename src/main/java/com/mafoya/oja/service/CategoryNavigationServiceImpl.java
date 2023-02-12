package com.mafoya.oja.service;


import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.CategoryNavigation;
import com.mafoya.oja.repository.CategoryNavigationRepository;

import java.util.List;
import java.util.Optional;

public class CategoryNavigationServiceImpl implements CategoryNavigationService {

    private final CategoryNavigationRepository navigationRepository;

    public CategoryNavigationServiceImpl(CategoryNavigationRepository navigationRepository) {
        this.navigationRepository = navigationRepository;
    }

    @Override
    public CategoryNavigation create(String authorization, CategoryNavigationDto NavigationDto) {
        return navigationRepository.save(OjaMapper.mapCategoryNavigationToDo(NavigationDto));
    }

    @Override
    public CategoryNavigation update(String authorization, CategoryNavigation Navigation, String id) {

        Optional<CategoryNavigation> NavigationOptional = navigationRepository.findById(id);
        if (NavigationOptional.isPresent()) {
//            NavigationOptional.get().setFirstName(Navigation.getFirstName());
//            NavigationOptional.get().setLastName(Navigation.getLastName());
//            NavigationOptional.get().setEmail(Navigation.getEmail());
//            NavigationOptional.get().setNumber(Navigation.getNumber());
//            NavigationOptional.get().setDepartment(Navigation.getDepartment());

            return navigationRepository.save(NavigationOptional.get());
        }
        throw new DataNotFoundException("Navigation Id not found");
    }

    @Override
    public Optional<CategoryNavigation> getById(String authorization, String id) {
        return navigationRepository.findById(id);
    }

    @Override
    public List<CategoryNavigation> getAll(String authorization) {
        return (List<CategoryNavigation>) navigationRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        navigationRepository.deleteById(id);
    }

}