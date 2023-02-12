package com.mafoya.oja.service;

import com.mafoya.oja.dto.DiscountCardDto;

import java.util.List;

public interface DiscountCardService {
    DiscountCardDto create(String authorization, DiscountCardDto discountCardDto);

    DiscountCardDto update(String authorization, DiscountCardDto discountCardDto, String id);

    DiscountCardDto getById(String authorization, String id);

    List<DiscountCardDto> getAll(String authorization);

    void delete(String authorization, String id);
}
