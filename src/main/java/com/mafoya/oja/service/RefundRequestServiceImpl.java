package com.mafoya.oja.service;

import com.mafoya.oja.model.RefundRequest;
import com.mafoya.oja.repository.RefundRequestRepository;

import java.util.List;
import java.util.Optional;

public class RefundRequestServiceImpl  implements RefundRequestService {

    private final RefundRequestRepository refundRequestRepository;

    public RefundRequestServiceImpl(RefundRequestRepository refundRequestRepository) {
        this.refundRequestRepository = refundRequestRepository;
    }

    @Override
    public RefundRequest create(String authorization, RefundRequest refundRequest) {
        return refundRequestRepository.save(refundRequest);
    }

    @Override
    public RefundRequest update(String authorization, RefundRequest refundRequest, String id) {
        return refundRequestRepository.save(refundRequest);
    }

    @Override
    public Optional<RefundRequest> getById(String authorization, String id) {
        return refundRequestRepository.findById(id);
    }

    @Override
    public List<RefundRequest> getAll(String authorization) {
        return (List<RefundRequest>) refundRequestRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        refundRequestRepository.deleteById(id);
    }
}

