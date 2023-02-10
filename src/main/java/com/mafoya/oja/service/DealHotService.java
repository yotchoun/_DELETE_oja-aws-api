package com.mafoya.oja.service;

import com.mafoya.oja.model.DealHot;

import java.util.List;
import java.util.Optional;

public interface DealHotService {
    DealHot create(String authorization, DealHot dealHot);

    DealHot update(String authorization, DealHot dealHot, String id);

    Optional<DealHot> getById(String authorization, String id);

    List<DealHot> getAll(String authorization);

    void delete(String authorization, String id);
}
