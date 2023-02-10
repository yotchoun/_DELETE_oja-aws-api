package com.mafoya.oja.service;

import com.mafoya.oja.model.Earning;
import com.mafoya.oja.repository.EarningRepository;

import java.util.List;
import java.util.Optional;

public class EarningServiceImpl  implements EarningService {

    private final EarningRepository earningRepository;

    public EarningServiceImpl(EarningRepository earningRepository) {
        this.earningRepository = earningRepository;
    }

    @Override
    public Earning create(String authorization, Earning earning) {
        return earningRepository.save(earning);
    }

    @Override
    public Earning update(String authorization, Earning earning, String id) {
        return earningRepository.save(earning);
    }

    @Override
    public Optional<Earning> getById(String authorization, String id) {
        return earningRepository.findById(id);
    }

    @Override
    public List<Earning> getAll(String authorization) {
        return (List<Earning>) earningRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        earningRepository.deleteById(id);
    }
}

