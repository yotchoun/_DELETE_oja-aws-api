package com.mafoya.oja.service;

import com.mafoya.oja.model.PaymentPackage;
import com.mafoya.oja.repository.PaymentPackageRepository;

import java.util.List;
import java.util.Optional;

public class PaymentPackageServiceImpl  implements PaymentPackageService {

    private final PaymentPackageRepository paymentPackageRepository;

    public PaymentPackageServiceImpl(PaymentPackageRepository paymentPackageRepository) {
        this.paymentPackageRepository = paymentPackageRepository;
    }

    @Override
    public PaymentPackage create(String authorization, PaymentPackage paymentPackage) {
        return paymentPackageRepository.save(paymentPackage);
    }

    @Override
    public PaymentPackage update(String authorization, PaymentPackage paymentPackage, String id) {
        return paymentPackageRepository.save(paymentPackage);
    }

    @Override
    public Optional<PaymentPackage> getById(String authorization, String id) {
        return paymentPackageRepository.findById(id);
    }

    @Override
    public List<PaymentPackage> getAll(String authorization) {
        return (List<PaymentPackage>) paymentPackageRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        paymentPackageRepository.deleteById(id);
    }
}
