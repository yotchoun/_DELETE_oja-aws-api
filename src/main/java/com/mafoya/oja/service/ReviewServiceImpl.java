package com.mafoya.oja.service;

import com.mafoya.oja.model.Review;
import com.mafoya.oja.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImpl  implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review create(String authorization, Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(String authorization, Review review, String id) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getById(String authorization, String id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> getAll(String authorization) {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        reviewRepository.deleteById(id);
    }
}

