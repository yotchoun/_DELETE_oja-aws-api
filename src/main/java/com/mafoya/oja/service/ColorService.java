package com.mafoya.oja.service;

import com.mafoya.oja.dto.ColorDto;

import java.util.List;
import java.util.Set;

public interface ColorService {
    ColorDto create(String authorization, ColorDto colorDto);

    ColorDto update(String authorization, ColorDto colorDto, String id);

    ColorDto getById(String authorization, String id);

    List<ColorDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<ColorDto> findByProductId(String authorization,String id);
}
