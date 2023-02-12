package com.mafoya.oja.service;

import com.mafoya.oja.dto.ColorDto;

import java.util.List;

public interface ColorService {
    ColorDto create(String authorization, ColorDto colorDto);

    ColorDto update(String authorization, ColorDto colorDto, String id);

    ColorDto getById(String authorization, String id);

    List<ColorDto> getAll(String authorization);

    void delete(String authorization, String id);
}
