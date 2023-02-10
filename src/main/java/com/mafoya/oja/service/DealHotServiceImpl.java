package com.mafoya.oja.service;

import com.mafoya.oja.model.DealHot;
import com.mafoya.oja.repository.DealHotRepository;

import java.util.List;
import java.util.Optional;

public class DealHotServiceImpl  implements DealHotService {

    private final DealHotRepository dealHotRepository;

    public DealHotServiceImpl(DealHotRepository dealHotRepository) {
        this.dealHotRepository = dealHotRepository;
    }

    @Override
    public DealHot create(String authorization, DealHot dealHot) {
        return dealHotRepository.save(dealHot);
    }

    @Override
    public DealHot update(String authorization, DealHot dealHot, String id) {
        return dealHotRepository.save(dealHot);
    }

    @Override
    public Optional<DealHot> getById(String authorization, String id) {
        return dealHotRepository.findById(id);
    }

    @Override
    public List<DealHot> getAll(String authorization) {
        return (List<DealHot>) dealHotRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        dealHotRepository.deleteById(id);
    }
}

