package com.mafoya.oja.service;

import com.mafoya.oja.model.Color;
import com.mafoya.oja.repository.ColorRepository;

import java.util.List;
import java.util.Optional;

public class ColorServiceImpl  implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public Color create(String authorization, Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color update(String authorization, Color color, String id) {
        return colorRepository.save(color);
    }

    @Override
    public Optional<Color> getById(String authorization, String id) {
        return colorRepository.findById(id);
    }

    @Override
    public List<Color> getAll(String authorization) {
        return (List<Color>) colorRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        colorRepository.deleteById(id);
    }
}

