package com.mafoya.oja.service;

import com.mafoya.oja.dto.ForDto;

import java.util.List;
import java.util.Optional;

public interface ForService {
    ForDto create(String authorization, ForDto forSer);

    ForDto update(String authorization, ForDto forSer, String id);

    ForDto getById(String authorization, String id);

    List<ForDto> getAll(String authorization);

    void delete(String authorization, String id);
}
