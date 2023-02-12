package com.mafoya.oja.service;

import com.mafoya.oja.dto.PayoutRequestDto;

import java.util.List;

public interface PayoutRequestService {
    PayoutRequestDto create(String authorization, PayoutRequestDto payoutRequestDto);

    PayoutRequestDto update(String authorization, PayoutRequestDto payoutRequestDto, String id);

    PayoutRequestDto getById(String authorization, String id);

    List<PayoutRequestDto> getAll(String authorization);

    void delete(String authorization, String id);
}
