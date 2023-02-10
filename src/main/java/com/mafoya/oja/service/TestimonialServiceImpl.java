package com.mafoya.oja.service;

import com.mafoya.oja.model.Testimonial;
import com.mafoya.oja.repository.TestimonialRepository;

import java.util.List;
import java.util.Optional;

public class TestimonialServiceImpl  implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public Testimonial create(String authorization, Testimonial testimonial) {
        return testimonialRepository.save(testimonial);
    }

    @Override
    public Testimonial update(String authorization, Testimonial testimonial, String id) {
        return testimonialRepository.save(testimonial);
    }

    @Override
    public Optional<Testimonial> getById(String authorization, String id) {
        return testimonialRepository.findById(id);
    }

    @Override
    public List<Testimonial> getAll(String authorization) {
        return (List<Testimonial>) testimonialRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        testimonialRepository.deleteById(id);
    }
}

