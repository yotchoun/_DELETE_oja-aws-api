package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.DiscountOffer;
import com.mafoya.oja.service.DiscountOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DiscountOfferController {

    @Autowired
    private DiscountOfferService discountOfferService;

    @GetMapping("/discountOffers/all")
    public List<DiscountOffer> findAll(@RequestHeader("authorization") String authorization) {
        return this.discountOfferService.getAll(authorization);
    }

    @GetMapping("/discountOffers/{id}")
    public Optional<DiscountOffer> getDiscountOfferById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.discountOfferService.getById(authorization, id);

    }

    @PostMapping("/discountOffers")
    public DiscountOffer createDiscountOffer(@RequestBody @Valid DiscountOffer discountOfferDto, @RequestHeader("authorization") String authorization) {
        return this.discountOfferService.create(authorization, discountOfferDto);
    }

    @PutMapping("/discountOffers/{id}")
    public DiscountOffer updateDiscountOffer(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody DiscountOffer discountOffer) {
        return this.discountOfferService.update(authorization, discountOffer, id);


    }

    @DeleteMapping("/discountOffers/{id}")
    public void deleteDiscountOffer(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.discountOfferService.delete(authorization, id);
    }
}

