package com.mafoya.oja.service;

import com.mafoya.oja.dto.RecentPurchaseDto;

import java.util.List;

public interface RecentPurchaseService {
    RecentPurchaseDto create(String authorization, RecentPurchaseDto recentPurchaseDto);

    RecentPurchaseDto update(String authorization, RecentPurchaseDto recentPurchaseDto, String id);

    RecentPurchaseDto getById(String authorization, String id);

    List<RecentPurchaseDto> getAll(String authorization);

    void delete(String authorization, String id);
}
