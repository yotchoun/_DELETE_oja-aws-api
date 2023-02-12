package com.mafoya.oja.service;

import com.mafoya.oja.dto.CarouselDto;

import java.util.List;

public interface CarouselService {
    CarouselDto create(String authorization, CarouselDto carouselDto);

    CarouselDto update(String authorization, CarouselDto carouselDto, String id);

    CarouselDto getById(String authorization, String id);

    List<CarouselDto> getAll(String authorization);

    void delete(String authorization, String id);
}
