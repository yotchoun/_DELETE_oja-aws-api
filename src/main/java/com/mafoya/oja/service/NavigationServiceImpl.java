package com.mafoya.oja.service;

import com.mafoya.oja.dto.NavigationDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.mapper.OjaMapper;
import com.mafoya.oja.model.Navigation;
import com.mafoya.oja.repository.NavigationRepository;

import java.util.List;
import java.util.Optional;

public class NavigationServiceImpl implements NavigationService {

    private final NavigationRepository NavigationRepository;

    public NavigationServiceImpl(NavigationRepository NavigationRepository) {
        this.NavigationRepository = NavigationRepository;
    }

    @Override
    public Navigation create(String authorization, NavigationDto NavigationDto) {
        return NavigationRepository.save(OjaMapper.mapNavigationToDo(NavigationDto));
    }

    @Override
    public Navigation update(String authorization, Navigation Navigation, String id) {

        Optional<Navigation> NavigationOptional = NavigationRepository.findById(id);
        if (NavigationOptional.isPresent()) {
            NavigationOptional.get().setFirstName(Navigation.getFirstName());
            NavigationOptional.get().setLastName(Navigation.getLastName());
            NavigationOptional.get().setEmail(Navigation.getEmail());
            NavigationOptional.get().setNumber(Navigation.getNumber());
            NavigationOptional.get().setDepartment(Navigation.getDepartment());

            return NavigationRepository.save(NavigationOptional.get());
        }
        throw new DataNotFoundException("Navigation Id not found");
    }

    @Override
    public Optional<Navigation> getById(String authorization, String id) {
        return NavigationRepository.findById(id);
    }

    @Override
    public List<Navigation> getAll(String authorization) {
        return (List<Navigation>) NavigationRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        NavigationRepository.deleteById(id);
    }

}