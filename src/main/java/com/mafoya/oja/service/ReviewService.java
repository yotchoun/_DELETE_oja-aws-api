package com.mafoya.oja.service;

import com.mafoya.oja.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto create(String authorization, ReviewDto reviewDto);

    ReviewDto update(String authorization, ReviewDto reviewDto, String id);

    ReviewDto getById(String authorization, String id);

    List<ReviewDto> getAll(String authorization);

    void delete(String authorization, String id);
}
