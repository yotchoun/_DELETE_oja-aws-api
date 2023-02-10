package com.mafoya.oja.service;

import com.mafoya.oja.model.DealOfTheWeek;

import java.util.List;
import java.util.Optional;

public interface DealOfTheWeekService {
    DealOfTheWeek create(String authorization, DealOfTheWeek dealOfTheWeek);

    DealOfTheWeek update(String authorization, DealOfTheWeek dealOfTheWeek, String id);

    Optional<DealOfTheWeek> getById(String authorization, String id);

    List<DealOfTheWeek> getAll(String authorization);

    void delete(String authorization, String id);
}
