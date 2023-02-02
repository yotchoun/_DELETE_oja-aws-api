package com.mafoya.oja.service;


import com.mafoya.oja.dto.NavigationDto;
import com.mafoya.oja.model.Navigation;

import java.util.List;
import java.util.Optional;

public interface NavigationService {

    Navigation create(String authorization, NavigationDto navigationDto);

    Navigation update(String authorization, Navigation navigation, String id);

    Optional<Navigation> getById(String authorization, String id);

    List<Navigation> getAll(String authorization);

    void delete(String authorization, String id);

}
