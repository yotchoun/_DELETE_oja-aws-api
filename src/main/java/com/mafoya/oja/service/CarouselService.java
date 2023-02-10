package com.mafoya.oja.service;

import com.mafoya.oja.model.Carousel;

import java.util.List;
import java.util.Optional;

public interface CarouselService {
    Carousel create(String authorization, Carousel carousel);

    Carousel update(String authorization, Carousel carousel, String id);

    Optional<Carousel> getById(String authorization, String id);

    List<Carousel> getAll(String authorization);

    void delete(String authorization, String id);
}
