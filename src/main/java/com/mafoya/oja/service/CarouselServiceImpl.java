package com.mafoya.oja.service;

import com.mafoya.oja.model.Carousel;
import com.mafoya.oja.repository.CarouselRepository;

import java.util.List;
import java.util.Optional;

public class CarouselServiceImpl  implements CarouselService {

    private final CarouselRepository carouselRepository;

    public CarouselServiceImpl(CarouselRepository carouselRepository) {
        this.carouselRepository = carouselRepository;
    }

    @Override
    public Carousel create(String authorization, Carousel carousel) {
        return carouselRepository.save(carousel);
    }

    @Override
    public Carousel update(String authorization, Carousel carousel, String id) {
        return carouselRepository.save(carousel);
    }

    @Override
    public Optional<Carousel> getById(String authorization, String id) {
        return carouselRepository.findById(id);
    }

    @Override
    public List<Carousel> getAll(String authorization) {
        return (List<Carousel>) carouselRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        carouselRepository.deleteById(id);
    }
}

