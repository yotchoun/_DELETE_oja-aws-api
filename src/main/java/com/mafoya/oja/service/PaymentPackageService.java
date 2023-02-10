package com.mafoya.oja.service;

import com.mafoya.oja.model.PaymentPackage;

import java.util.List;
import java.util.Optional;

public interface PaymentPackageService {
    PaymentPackage create(String authorization, PaymentPackage paymentPackage);

    PaymentPackage update(String authorization, PaymentPackage paymentPackage, String id);

    Optional<PaymentPackage> getById(String authorization, String id);

    List<PaymentPackage> getAll(String authorization);

    void delete(String authorization, String id);
}
