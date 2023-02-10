package com.mafoya.oja.service;

import com.mafoya.oja.model.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    Color create(String authorization, Color color);

    Color update(String authorization, Color color, String id);

    Optional<Color> getById(String authorization, String id);

    List<Color> getAll(String authorization);

    void delete(String authorization, String id);
}
