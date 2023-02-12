package com.mafoya.oja.service;

import com.mafoya.oja.dto.DiscountOfferDto;

import java.util.List;

public interface DiscountOfferService {
    DiscountOfferDto create(String authorization, DiscountOfferDto discountOfferDto);

    DiscountOfferDto update(String authorization, DiscountOfferDto discountOfferDto, String id);

    DiscountOfferDto getById(String authorization, String id);

    List<DiscountOfferDto> getAll(String authorization);

    void delete(String authorization, String id);
}
