package com.mafoya.oja.service;

import com.mafoya.oja.model.Visitor;
import com.mafoya.oja.repository.VisitorRepository;

import java.util.List;
import java.util.Optional;

public class VisitorServiceImpl  implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor create(String authorization, Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor update(String authorization, Visitor visitor, String id) {
        return visitorRepository.save(visitor);
    }

    @Override
    public Optional<Visitor> getById(String authorization, String id) {
        return visitorRepository.findById(id);
    }

    @Override
    public List<Visitor> getAll(String authorization) {
        return (List<Visitor>) visitorRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        visitorRepository.deleteById(id);
    }
}

