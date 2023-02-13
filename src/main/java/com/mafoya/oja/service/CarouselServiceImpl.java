package com.mafoya.oja.service;

import com.mafoya.oja.dto.CarouselDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Carousel;
import com.mafoya.oja.repository.CarouselRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarouselServiceImpl  implements CarouselService {

    private final CarouselRepository carouselRepository;

    public CarouselServiceImpl(CarouselRepository carouselRepository) {
        this.carouselRepository = carouselRepository;
    }

    @Override
    public CarouselDto getById(String authorization, String id) {
        CarouselDto carouselDto;
        Optional<Carousel> carouselOptional = carouselRepository.findById(id);
        if (carouselOptional.isPresent()) {
            carouselDto = OjaMapper.mapCarouselDto(carouselOptional.get());
            return carouselDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public CarouselDto create(String authorization, CarouselDto carouselDto) {
        Carousel carousel = OjaMapper.mapCarouselDo(carouselDto);
        carouselRepository.save(carousel);
        return carouselDto;
    }

    @Override
    public CarouselDto update(String authorization, CarouselDto carouselDto, String id) {
        Optional<Carousel> carouselOptional = carouselRepository.findById(id);
        if (carouselOptional.isPresent()) {
            Carousel carousel = OjaMapper.mapCarouselDo(carouselDto);
            carousel.setId(id);
            carouselRepository.save(carousel);
            return carouselDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<CarouselDto> getAll(String authorization) {
        List<Carousel> doList = (List<Carousel>) carouselRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        carouselRepository.deleteById(id);
    }
}

