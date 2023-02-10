package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Review;
import com.mafoya.oja.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews/all")
    public List<Review> findAll(@RequestHeader("authorization") String authorization) {
        return this.reviewService.getAll(authorization);
    }

    @GetMapping("/reviews/{id}")
    public Optional<Review> getReviewById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.reviewService.getById(authorization, id);

    }

    @PostMapping("/reviews")
    public Review createReview(@RequestBody @Valid Review reviewDto, @RequestHeader("authorization") String authorization) {
        return this.reviewService.create(authorization, reviewDto);
    }

    @PutMapping("/reviews/{id}")
    public Review updateReview(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Review review) {
        return this.reviewService.update(authorization, review, id);


    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.reviewService.delete(authorization, id);
    }
}

