package com.mafoya.oja.service;

import com.mafoya.oja.dto.PayoutRequestDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.PayoutRequest;
import com.mafoya.oja.model.PayoutRequest;
import com.mafoya.oja.repository.PayoutRequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PayoutRequestServiceImpl  implements PayoutRequestService {

    private final PayoutRequestRepository payoutRequestRepository;

    public PayoutRequestServiceImpl(PayoutRequestRepository payoutRequestRepository) {
        this.payoutRequestRepository = payoutRequestRepository;
    }

    @Override
    public PayoutRequestDto getById(String authorization, String id) {
        PayoutRequestDto payoutRequestDto;
        Optional<PayoutRequest> payoutRequestOptional = payoutRequestRepository.findById(id);
        if (payoutRequestOptional.isPresent()) {
            payoutRequestDto = OjaMapper.mapPayoutRequestDto(payoutRequestOptional.get());
            return payoutRequestDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public PayoutRequestDto create(String authorization, PayoutRequestDto payoutRequestDto) {
        PayoutRequest payoutRequest = OjaMapper.mapPayoutRequestDo(payoutRequestDto);
        payoutRequestRepository.save(payoutRequest);
        return payoutRequestDto;
    }

    @Override
    public PayoutRequestDto update(String authorization, PayoutRequestDto payoutRequestDto, String id) {
        Optional<PayoutRequest> payoutRequestOptional = payoutRequestRepository.findById(id);
        if (payoutRequestOptional.isPresent()) {
            PayoutRequest payoutRequest = OjaMapper.mapPayoutRequestDo(payoutRequestDto);
            payoutRequest.setId(id);
            payoutRequestRepository.save(payoutRequest);
            return payoutRequestDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<PayoutRequestDto> getAll(String authorization) {
        List<PayoutRequest> doList = (List<PayoutRequest>) payoutRequestRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        payoutRequestRepository.deleteById(id);
    }
}

