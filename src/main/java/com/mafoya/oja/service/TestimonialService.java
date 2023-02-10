package com.mafoya.oja.service;

import com.mafoya.oja.model.Testimonial;

import java.util.List;
import java.util.Optional;

public interface TestimonialService {
    Testimonial create(String authorization, Testimonial testimonial);

    Testimonial update(String authorization, Testimonial testimonial, String id);

    Optional<Testimonial> getById(String authorization, String id);

    List<Testimonial> getAll(String authorization);

    void delete(String authorization, String id);
}
