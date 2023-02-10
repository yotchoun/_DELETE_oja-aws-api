package com.mafoya.oja.service;

import com.mafoya.oja.model.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    Card create(String authorization, Card card);

    Card update(String authorization, Card card, String id);

    Optional<Card> getById(String authorization, String id);

    List<Card> getAll(String authorization);

    void delete(String authorization, String id);
}
