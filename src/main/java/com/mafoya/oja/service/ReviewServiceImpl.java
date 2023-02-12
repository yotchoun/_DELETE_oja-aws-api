package com.mafoya.oja.service;

import com.mafoya.oja.dto.ReviewDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Review;
import com.mafoya.oja.model.Review;
import com.mafoya.oja.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReviewServiceImpl  implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ReviewDto getById(String authorization, String id) {
        ReviewDto reviewDto;
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            reviewDto = OjaMapper.mapReviewDto(reviewOptional.get());
            return reviewDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ReviewDto create(String authorization, ReviewDto reviewDto) {
        Review review = OjaMapper.mapReviewDo(reviewDto);
        reviewRepository.save(review);
        return reviewDto;
    }

    @Override
    public ReviewDto update(String authorization, ReviewDto reviewDto, String id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review review = OjaMapper.mapReviewDo(reviewDto);
            review.setId(id);
            reviewRepository.save(review);
            return reviewDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ReviewDto> getAll(String authorization) {
        List<Review> doList = (List<Review>) reviewRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        reviewRepository.deleteById(id);
    }
}

