package com.mafoya.oja.service;

import com.mafoya.oja.dto.RefundRequestDto;

import java.util.List;

public interface RefundRequestService {
    RefundRequestDto create(String authorization, RefundRequestDto refundRequestDto);

    RefundRequestDto update(String authorization, RefundRequestDto refundRequestDto, String id);

    RefundRequestDto getById(String authorization, String id);

    List<RefundRequestDto> getAll(String authorization);

    void delete(String authorization, String id);
}
