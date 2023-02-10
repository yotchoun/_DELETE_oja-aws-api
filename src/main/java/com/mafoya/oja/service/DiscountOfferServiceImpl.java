package com.mafoya.oja.service;

import com.mafoya.oja.model.DiscountOffer;
import com.mafoya.oja.repository.DiscountOfferRepository;

import java.util.List;
import java.util.Optional;

public class DiscountOfferServiceImpl  implements DiscountOfferService {

    private final DiscountOfferRepository discountOfferRepository;

    public DiscountOfferServiceImpl(DiscountOfferRepository discountOfferRepository) {
        this.discountOfferRepository = discountOfferRepository;
    }

    @Override
    public DiscountOffer create(String authorization, DiscountOffer discountOffer) {
        return discountOfferRepository.save(discountOffer);
    }

    @Override
    public DiscountOffer update(String authorization, DiscountOffer discountOffer, String id) {
        return discountOfferRepository.save(discountOffer);
    }

    @Override
    public Optional<DiscountOffer> getById(String authorization, String id) {
        return discountOfferRepository.findById(id);
    }

    @Override
    public List<DiscountOffer> getAll(String authorization) {
        return (List<DiscountOffer>) discountOfferRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        discountOfferRepository.deleteById(id);
    }
}

