package com.mafoya.oja.service;

import com.mafoya.oja.model.PayoutRequest;
import com.mafoya.oja.repository.PayoutRequestRepository;

import java.util.List;
import java.util.Optional;

public class PayoutRequestServiceImpl  implements PayoutRequestService {

    private final PayoutRequestRepository payoutRequestRepository;

    public PayoutRequestServiceImpl(PayoutRequestRepository payoutRequestRepository) {
        this.payoutRequestRepository = payoutRequestRepository;
    }

    @Override
    public PayoutRequest create(String authorization, PayoutRequest payoutRequest) {
        return payoutRequestRepository.save(payoutRequest);
    }

    @Override
    public PayoutRequest update(String authorization, PayoutRequest payoutRequest, String id) {
        return payoutRequestRepository.save(payoutRequest);
    }

    @Override
    public Optional<PayoutRequest> getById(String authorization, String id) {
        return payoutRequestRepository.findById(id);
    }

    @Override
    public List<PayoutRequest> getAll(String authorization) {
        return (List<PayoutRequest>) payoutRequestRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        payoutRequestRepository.deleteById(id);
    }
}

