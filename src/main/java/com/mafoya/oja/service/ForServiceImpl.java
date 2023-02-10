package com.mafoya.oja.service;

import com.mafoya.oja.model.For;
import com.mafoya.oja.repository.ForRepository;

import java.util.List;
import java.util.Optional;

public class ForServiceImpl  implements ForService {

    private final ForRepository ForSerRepository;

    public ForServiceImpl(ForRepository ForSerRepository) {
        this.ForSerRepository = ForSerRepository;
    }

    @Override
    public For create(String authorization, For ForSer) {
        return ForSerRepository.save(ForSer);
    }

    @Override
    public For update(String authorization, For ForSer, String id) {
        return ForSerRepository.save(ForSer);
    }

    @Override
    public Optional<For> getById(String authorization, String id) {
        return ForSerRepository.findById(id);
    }

    @Override
    public List<For> getAll(String authorization) {
        return (List<For>) ForSerRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        ForSerRepository.deleteById(id);
    }
}

