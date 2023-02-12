package com.mafoya.oja.service;

import com.mafoya.oja.dto.PayoutDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Payout;
import com.mafoya.oja.model.Payout;
import com.mafoya.oja.repository.PayoutRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PayoutServiceImpl  implements PayoutService {

    private final PayoutRepository payoutRepository;

    public PayoutServiceImpl(PayoutRepository payoutRepository) {
        this.payoutRepository = payoutRepository;
    }

    @Override
    public PayoutDto getById(String authorization, String id) {
        PayoutDto payoutDto;
        Optional<Payout> payoutOptional = payoutRepository.findById(id);
        if (payoutOptional.isPresent()) {
            payoutDto = OjaMapper.mapPayoutDto(payoutOptional.get());
            return payoutDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public PayoutDto create(String authorization, PayoutDto payoutDto) {
        Payout payout = OjaMapper.mapPayoutDo(payoutDto);
        payoutRepository.save(payout);
        return payoutDto;
    }

    @Override
    public PayoutDto update(String authorization, PayoutDto payoutDto, String id) {
        Optional<Payout> payoutOptional = payoutRepository.findById(id);
        if (payoutOptional.isPresent()) {
            Payout payout = OjaMapper.mapPayoutDo(payoutDto);
            payout.setId(id);
            payoutRepository.save(payout);
            return payoutDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<PayoutDto> getAll(String authorization) {
        List<Payout> doList = (List<Payout>) payoutRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        payoutRepository.deleteById(id);
    }
}

