package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.CarouselDto;
import com.mafoya.oja.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @GetMapping("/carousels/all")
    public List<CarouselDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.carouselService.getAll(authorization);
    }

    @GetMapping("/carousels/{id}")
    public CarouselDto getCarouselById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.carouselService.getById(authorization, id);

    }

    @PostMapping("/carousels")
    public CarouselDto createCarousel(@RequestBody @Valid CarouselDto carouselDto, @RequestHeader("authorization") String authorization) {
        return this.carouselService.create(authorization, carouselDto);
    }

    @PutMapping("/carousels/{id}")
    public CarouselDto updateCarousel(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody CarouselDto carouselDto) {
        return this.carouselService.update(authorization, carouselDto, id);


    }

    @DeleteMapping("/carousels/{id}")
    public void deleteCarousel(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.carouselService.delete(authorization, id);
    }
}

