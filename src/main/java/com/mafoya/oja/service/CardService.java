package com.mafoya.oja.service;

import com.mafoya.oja.dto.CardDto;

import java.util.List;

public interface CardService {
    CardDto create(String authorization, CardDto cardDto);

    CardDto update(String authorization, CardDto cardDto, String id);

    CardDto getById(String authorization, String id);

    List<CardDto> getAll(String authorization);

    void delete(String authorization, String id);
}
