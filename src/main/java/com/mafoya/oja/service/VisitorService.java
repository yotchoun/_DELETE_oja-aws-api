package com.mafoya.oja.service;

import com.mafoya.oja.model.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorService {
    Visitor create(String authorization, Visitor visitor);

    Visitor update(String authorization, Visitor visitor, String id);

    Optional<Visitor> getById(String autohrization, String id);

    List<Visitor> getAll(String authorization);

    void delete(String authorization, String id);
}
