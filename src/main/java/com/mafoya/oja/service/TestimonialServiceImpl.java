package com.mafoya.oja.service;

import com.mafoya.oja.dto.TestimonialDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Testimonial;
import com.mafoya.oja.repository.TestimonialRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestimonialServiceImpl  implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public TestimonialDto getById(String authorization, String id) {
        TestimonialDto testimonialDto;
        Optional<Testimonial> testimonialOptional = testimonialRepository.findById(id);
        if (testimonialOptional.isPresent()) {
            testimonialDto = OjaMapper.mapTestimonialDto(testimonialOptional.get());
            return testimonialDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public TestimonialDto create(String authorization, TestimonialDto testimonialDto) {
        Testimonial testimonial = OjaMapper.mapTestimonialDo(testimonialDto);
        testimonialRepository.save(testimonial);
        return testimonialDto;
    }

    @Override
    public TestimonialDto update(String authorization, TestimonialDto testimonialDto, String id) {
        Optional<Testimonial> testimonialOptional = testimonialRepository.findById(id);
        if (testimonialOptional.isPresent()) {
            Testimonial testimonial = OjaMapper.mapTestimonialDo(testimonialDto);
            testimonial.setId(id);
            testimonialRepository.save(testimonial);
            return testimonialDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<TestimonialDto> getAll(String authorization) {
        List<Testimonial> doList = (List<Testimonial>) testimonialRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        testimonialRepository.deleteById(id);
    }
}

