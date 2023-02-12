package com.mafoya.oja.service;

import com.mafoya.oja.dto.EarningDto;

import java.util.List;

public interface EarningService {
    EarningDto create(String authorization, EarningDto earningDto);

    EarningDto update(String authorization, EarningDto earningDto, String id);

    EarningDto getById(String authorization, String id);

    List<EarningDto> getAll(String authorization);

    void delete(String authorization, String id);
}
