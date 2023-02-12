package com.mafoya.oja.service;

import com.mafoya.oja.dto.DealOfTheWeekDto;

import java.util.List;

public interface DealOfTheWeekService {
    DealOfTheWeekDto create(String authorization, DealOfTheWeekDto dealOfTheWeekDto);

    DealOfTheWeekDto update(String authorization, DealOfTheWeekDto dealOfTheWeekDto, String id);

    DealOfTheWeekDto getById(String authorization, String id);

    List<DealOfTheWeekDto> getAll(String authorization);

    void delete(String authorization, String id);
}
