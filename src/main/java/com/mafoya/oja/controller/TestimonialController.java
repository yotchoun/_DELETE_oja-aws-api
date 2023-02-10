package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Testimonial;
import com.mafoya.oja.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class TestimonialController{

    @Autowired
    private TestimonialService testimonialService;

    @GetMapping("/testimonials/all")
    public List<Testimonial> findAll(@RequestHeader("authorization") String authorization) {
        return this.testimonialService.getAll(authorization);
    }

    @GetMapping("/testimonials/{id}")
    public Optional<Testimonial> getTestimonialById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.testimonialService.getById(authorization, id);

    }

    @PostMapping("/testimonials")
    public Testimonial createTestimonial(@RequestBody @Valid Testimonial testimonialDto, @RequestHeader("authorization") String authorization) {
        return this.testimonialService.create(authorization, testimonialDto);
    }

    @PutMapping("/testimonials/{id}")
    public Testimonial updateTestimonial(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Testimonial testimonial) {
        return this.testimonialService.update(authorization, testimonial, id);


    }

    @DeleteMapping("/testimonials/{id}")
    public void deleteTestimonial(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.testimonialService.delete(authorization, id);
    }
}

