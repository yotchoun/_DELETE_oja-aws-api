package com.mafoya.oja.service;

import com.mafoya.oja.dto.ColorDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Color;
import com.mafoya.oja.model.Color;
import com.mafoya.oja.repository.ColorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ColorServiceImpl  implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public ColorDto getById(String authorization, String id) {
        ColorDto colorDto;
        Optional<Color> colorOptional = colorRepository.findById(id);
        if (colorOptional.isPresent()) {
            colorDto = OjaMapper.mapColorDto(colorOptional.get());
            return colorDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ColorDto create(String authorization, ColorDto colorDto) {
        Color color = OjaMapper.mapColorDo(colorDto);
        colorRepository.save(color);
        return colorDto;
    }

    @Override
    public ColorDto update(String authorization, ColorDto colorDto, String id) {
        Optional<Color> colorOptional = colorRepository.findById(id);
        if (colorOptional.isPresent()) {
            Color color = OjaMapper.mapColorDo(colorDto);
            color.setId(id);
            colorRepository.save(color);
            return colorDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ColorDto> getAll(String authorization) {
        List<Color> doList = (List<Color>) colorRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        colorRepository.deleteById(id);
    }
}

