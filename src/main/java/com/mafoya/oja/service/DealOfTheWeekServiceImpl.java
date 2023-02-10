package com.mafoya.oja.service;

import com.mafoya.oja.model.DealOfTheWeek;
import com.mafoya.oja.repository.DealOfTheWeekRepository;

import java.util.List;
import java.util.Optional;

public class DealOfTheWeekServiceImpl  implements DealOfTheWeekService {

    private final DealOfTheWeekRepository dealOfTheWeekRepository;

    public DealOfTheWeekServiceImpl(DealOfTheWeekRepository dealOfTheWeekRepository) {
        this.dealOfTheWeekRepository = dealOfTheWeekRepository;
    }

    @Override
    public DealOfTheWeek create(String authorization, DealOfTheWeek dealOfTheWeek) {
        return dealOfTheWeekRepository.save(dealOfTheWeek);
    }

    @Override
    public DealOfTheWeek update(String authorization, DealOfTheWeek dealOfTheWeek, String id) {
        return dealOfTheWeekRepository.save(dealOfTheWeek);
    }

    @Override
    public Optional<DealOfTheWeek> getById(String authorization, String id) {
        return dealOfTheWeekRepository.findById(id);
    }

    @Override
    public List<DealOfTheWeek> getAll(String authorization) {
        return (List<DealOfTheWeek>) dealOfTheWeekRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        dealOfTheWeekRepository.deleteById(id);
    }
}

