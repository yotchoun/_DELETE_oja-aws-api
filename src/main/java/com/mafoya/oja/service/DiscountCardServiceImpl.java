package com.mafoya.oja.service;

import com.mafoya.oja.model.DiscountCard;
import com.mafoya.oja.repository.DiscountCardRepository;

import java.util.List;
import java.util.Optional;

public class DiscountCardServiceImpl  implements DiscountCardService {

    private final DiscountCardRepository discountCardRepository;

    public DiscountCardServiceImpl(DiscountCardRepository discountCardRepository) {
        this.discountCardRepository = discountCardRepository;
    }

    @Override
    public DiscountCard create(String authorization, DiscountCard discountCard) {
        return discountCardRepository.save(discountCard);
    }

    @Override
    public DiscountCard update(String authorization, DiscountCard discountCard, String id) {
        return discountCardRepository.save(discountCard);
    }

    @Override
    public Optional<DiscountCard> getById(String authorization, String id) {
        return discountCardRepository.findById(id);
    }

    @Override
    public List<DiscountCard> getAll(String authorization) {
        return (List<DiscountCard>) discountCardRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        discountCardRepository.deleteById(id);
    }
}

