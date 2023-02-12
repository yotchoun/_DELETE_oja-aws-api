package com.mafoya.oja.service;

import com.mafoya.oja.dto.BrandDto;

import java.util.List;

public interface BrandService {

    BrandDto create(String authorization, BrandDto brandDto);

    BrandDto update(String authorization, BrandDto brandDto, String id);

    BrandDto getById(String authorization, String id);

    List<BrandDto> getAll(String authorization);

    void delete(String authorization, String id);
}
