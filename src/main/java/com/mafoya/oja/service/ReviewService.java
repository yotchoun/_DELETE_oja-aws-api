package com.mafoya.oja.service;

import com.mafoya.oja.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review create(String authorization, Review review);

    Review update(String authorization, Review review, String id);

    Optional<Review> getById(String authorization, String id);

    List<Review> getAll(String authorization);

    void delete(String authorization, String id);
}
