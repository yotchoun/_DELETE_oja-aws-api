package com.mafoya.oja.service;

import com.mafoya.oja.model.For;

import java.util.List;
import java.util.Optional;

public interface ForService {
    For create(String authorization, For forSer);

    For update(String authorization, For forSer, String id);

    Optional<For> getById(String authorization, String id);

    List<For> getAll(String authorization);

    void delete(String authorization, String id);
}
