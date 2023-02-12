package com.mafoya.oja.service;

import com.mafoya.oja.dto.DealHotDto;

import java.util.List;

public interface DealHotService {
    DealHotDto create(String authorization, DealHotDto dealHotDto);

    DealHotDto update(String authorization, DealHotDto dealHotDto, String id);

    DealHotDto getById(String authorization, String id);

    List<DealHotDto> getAll(String authorization);

    void delete(String authorization, String id);
}
