package com.mafoya.oja.service;

import com.mafoya.oja.model.Card;
import com.mafoya.oja.repository.CardRepository;

import java.util.List;
import java.util.Optional;

public class CardServiceImpl  implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card create(String authorization, Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card update(String authorization, Card card, String id) {
        return cardRepository.save(card);
    }

    @Override
    public Optional<Card> getById(String authorization, String id) {
        return cardRepository.findById(id);
    }

    @Override
    public List<Card> getAll(String authorization) {
        return (List<Card>) cardRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        cardRepository.deleteById(id);
    }
}

