package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.DiscountOfferDto;
import com.mafoya.oja.service.DiscountOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DiscountOfferController {

    @Autowired
    private DiscountOfferService discountOfferService;

    @GetMapping("/discountOffers/all")
    public List<DiscountOfferDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.discountOfferService.getAll(authorization);
    }

    @GetMapping("/discountOffers/{id}")
    public DiscountOfferDto getDiscountOfferById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.discountOfferService.getById(authorization, id);

    }

    @PostMapping("/discountOffers")
    public DiscountOfferDto createDiscountOffer(@RequestBody @Valid DiscountOfferDto discountOfferDto, @RequestHeader("authorization") String authorization) {
        return this.discountOfferService.create(authorization, discountOfferDto);
    }

    @PutMapping("/discountOffers/{id}")
    public DiscountOfferDto updateDiscountOffer(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody DiscountOfferDto discountOfferDto) {
        return this.discountOfferService.update(authorization, discountOfferDto, id);


    }

    @DeleteMapping("/discountOffers/{id}")
    public void deleteDiscountOffer(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.discountOfferService.delete(authorization, id);
    }
}

