package com.mafoya.oja.service;

import com.mafoya.oja.dto.PaymentPackageDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.PaymentPackage;
import com.mafoya.oja.repository.PaymentPackageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaymentPackageServiceImpl  implements PaymentPackageService {

    private final PaymentPackageRepository paymentPackageRepository;

    public PaymentPackageServiceImpl(PaymentPackageRepository paymentPackageRepository) {
        this.paymentPackageRepository = paymentPackageRepository;
    }

    @Override
    public PaymentPackageDto getById(String authorization, String id) {
        PaymentPackageDto paymentPackageDto;
        Optional<PaymentPackage> paymentPackageOptional = paymentPackageRepository.findById(id);
        if (paymentPackageOptional.isPresent()) {
            paymentPackageDto = OjaMapper.mapPaymentPackageDto(paymentPackageOptional.get());
            return paymentPackageDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public PaymentPackageDto create(String authorization, PaymentPackageDto paymentPackageDto) {
        PaymentPackage paymentPackage = OjaMapper.mapPaymentPackageDo(paymentPackageDto);
        paymentPackageRepository.save(paymentPackage);
        return paymentPackageDto;
    }

    @Override
    public PaymentPackageDto update(String authorization, PaymentPackageDto paymentPackageDto, String id) {
        Optional<PaymentPackage> paymentPackageOptional = paymentPackageRepository.findById(id);
        if (paymentPackageOptional.isPresent()) {
            PaymentPackage paymentPackage = OjaMapper.mapPaymentPackageDo(paymentPackageDto);
            paymentPackage.setId(id);
            paymentPackageRepository.save(paymentPackage);
            return paymentPackageDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<PaymentPackageDto> getAll(String authorization) {
        List<PaymentPackage> doList = (List<PaymentPackage>) paymentPackageRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        paymentPackageRepository.deleteById(id);
    }
}
