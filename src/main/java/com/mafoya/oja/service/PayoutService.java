package com.mafoya.oja.service;

import com.mafoya.oja.model.Payout;

import java.util.List;
import java.util.Optional;

public interface PayoutService {
    Payout create(String authorization, Payout payout);

    Payout update(String authorization, Payout payout, String id);

    Optional<Payout> getById(String authorization, String id);

    List<Payout> getAll(String authorization);

    void delete(String authorization, String id);
}
