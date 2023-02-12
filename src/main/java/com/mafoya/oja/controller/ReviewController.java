package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.ReviewDto;
import com.mafoya.oja.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews/all")
    public List<ReviewDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.reviewService.getAll(authorization);
    }

    @GetMapping("/reviews/{id}")
    public ReviewDto getReviewById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.reviewService.getById(authorization, id);

    }

    @PostMapping("/reviews")
    public ReviewDto createReview(@RequestBody @Valid ReviewDto reviewDto, @RequestHeader("authorization") String authorization) {
        return this.reviewService.create(authorization, reviewDto);
    }

    @PutMapping("/reviews/{id}")
    public ReviewDto updateReview(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ReviewDto reviewDto) {
        return this.reviewService.update(authorization, reviewDto, id);


    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.reviewService.delete(authorization, id);
    }
}

