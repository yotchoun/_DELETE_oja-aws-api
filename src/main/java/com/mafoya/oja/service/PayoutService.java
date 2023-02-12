package com.mafoya.oja.service;

import com.mafoya.oja.dto.PayoutDto;

import java.util.List;

public interface PayoutService {
    PayoutDto create(String authorization, PayoutDto payoutDto);

    PayoutDto update(String authorization, PayoutDto payoutDto, String id);

    PayoutDto getById(String authorization, String id);

    List<PayoutDto> getAll(String authorization);

    void delete(String authorization, String id);
}
