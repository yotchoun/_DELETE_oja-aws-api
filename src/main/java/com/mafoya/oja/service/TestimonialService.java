package com.mafoya.oja.service;

import com.mafoya.oja.dto.TestimonialDto;

import java.util.List;
import java.util.Set;

public interface TestimonialService {
    TestimonialDto create(String authorization, TestimonialDto testimonialDto);

    TestimonialDto update(String authorization, TestimonialDto testimonialDto, String id);

    TestimonialDto getById(String authorization, String id);

    List<TestimonialDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<TestimonialDto> findByUserId(String authorization,String id);
}
