package com.mafoya.oja.service;

import com.mafoya.oja.model.DiscountCard;

import java.util.List;
import java.util.Optional;

public interface DiscountCardService {
    DiscountCard create(String authorization, DiscountCard discountCard);

    DiscountCard update(String authorization, DiscountCard discountCard, String id);

    Optional<DiscountCard> getById(String authorization, String id);

    List<DiscountCard> getAll(String authorization);

    void delete(String authorization, String id);
}
