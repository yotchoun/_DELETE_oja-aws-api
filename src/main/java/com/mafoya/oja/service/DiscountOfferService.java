package com.mafoya.oja.service;

import com.mafoya.oja.model.DiscountOffer;

import java.util.List;
import java.util.Optional;

public interface DiscountOfferService {
    DiscountOffer create(String authorization, DiscountOffer discountOffer);

    DiscountOffer update(String authorization, DiscountOffer discountOffer, String id);

    Optional<DiscountOffer> getById(String authorization, String id);

    List<DiscountOffer> getAll(String authorization);

    void delete(String authorization, String id);
}
