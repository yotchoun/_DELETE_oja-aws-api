package com.mafoya.oja.service;

import com.mafoya.oja.dto.VisitorDto;

import java.util.List;

public interface VisitorService {
    VisitorDto create(String authorization, VisitorDto visitorDto);

    VisitorDto update(String authorization, VisitorDto visitorDto, String id);

    VisitorDto getById(String authorization, String id);

    List<VisitorDto> getAll(String authorization);

    void delete(String authorization, String id);
}
