package com.mafoya.oja.service;

import com.mafoya.oja.model.Earning;

import java.util.List;
import java.util.Optional;

public interface EarningService {
    Earning create(String authorization, Earning earning);

    Earning update(String authorization, Earning earning, String id);

    Optional<Earning> getById(String authorization, String id);

    List<Earning> getAll(String authorization);

    void delete(String authorization, String id);
}
