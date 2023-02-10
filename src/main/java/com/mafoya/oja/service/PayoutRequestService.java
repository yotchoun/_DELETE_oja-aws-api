package com.mafoya.oja.service;

import com.mafoya.oja.model.PayoutRequest;

import java.util.List;
import java.util.Optional;

public interface PayoutRequestService {
    PayoutRequest create(String authorization, PayoutRequest payoutRequest);

    PayoutRequest update(String authorization, PayoutRequest payoutRequest, String id);

    Optional<PayoutRequest> getById(String authorization, String id);

    List<PayoutRequest> getAll(String authorization);

    void delete(String authorization, String id);
}
