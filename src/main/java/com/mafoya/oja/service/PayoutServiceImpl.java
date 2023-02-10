package com.mafoya.oja.service;

import com.mafoya.oja.model.Payout;
import com.mafoya.oja.repository.PayoutRepository;

import java.util.List;
import java.util.Optional;

public class PayoutServiceImpl  implements PayoutService {

    private final PayoutRepository payoutRepository;

    public PayoutServiceImpl(PayoutRepository payoutRepository) {
        this.payoutRepository = payoutRepository;
    }

    @Override
    public Payout create(String authorization, Payout payout) {
        return payoutRepository.save(payout);
    }

    @Override
    public Payout update(String authorization, Payout payout, String id) {
        return payoutRepository.save(payout);
    }

    @Override
    public Optional<Payout> getById(String authorization, String id) {
        return payoutRepository.findById(id);
    }

    @Override
    public List<Payout> getAll(String authorization) {
        return (List<Payout>) payoutRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        payoutRepository.deleteById(id);
    }
}

