package com.mafoya.oja.service;

import com.mafoya.oja.dto.CardDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Card;
import com.mafoya.oja.repository.CardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CardServiceImpl  implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardDto getById(String authorization, String id) {
        CardDto cardDto;
        Optional<Card> cardOptional = cardRepository.findById(id);
        if (cardOptional.isPresent()) {
            cardDto = OjaMapper.mapCardDto(cardOptional.get());
            return cardDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public CardDto create(String authorization, CardDto cardDto) {
        Card card = OjaMapper.mapCardDo(cardDto);
        cardRepository.save(card);
        return cardDto;
    }

    @Override
    public CardDto update(String authorization, CardDto cardDto, String id) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if (cardOptional.isPresent()) {
            Card card = OjaMapper.mapCardDo(cardDto);
            card.setId(id);
            cardRepository.save(card);
            return cardDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<CardDto> getAll(String authorization) {
        List<Card> doList = (List<Card>) cardRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        cardRepository.deleteById(id);
    }
}

