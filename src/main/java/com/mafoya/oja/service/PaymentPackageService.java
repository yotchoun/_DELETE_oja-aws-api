package com.mafoya.oja.service;

import com.mafoya.oja.dto.PaymentPackageDto;

import java.util.List;

public interface PaymentPackageService {
    PaymentPackageDto create(String authorization, PaymentPackageDto paymentPackageDto);

    PaymentPackageDto update(String authorization, PaymentPackageDto paymentPackageDto, String id);

    PaymentPackageDto getById(String authorization, String id);

    List<PaymentPackageDto> getAll(String authorization);

    void delete(String authorization, String id);
}
