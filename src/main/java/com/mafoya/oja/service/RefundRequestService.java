package com.mafoya.oja.service;

import com.mafoya.oja.model.RefundRequest;

import java.util.List;
import java.util.Optional;

public interface RefundRequestService {
    RefundRequest create(String authorization, RefundRequest refundRequest);

    RefundRequest update(String authorization, RefundRequest refundRequest, String id);

    Optional<RefundRequest> getById(String authorization, String id);

    List<RefundRequest> getAll(String authorization);

    void delete(String authorization, String id);
}
