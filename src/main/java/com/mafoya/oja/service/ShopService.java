package com.mafoya.oja.service;

import com.mafoya.oja.dto.ShopDto;

import java.util.List;

public interface ShopService {

    ShopDto create(String authorization, ShopDto shopDto);

    ShopDto update(String authorization, ShopDto shopDto, String id);

    ShopDto getById(String authorization, String id);

    List<ShopDto> getAll(String authorization);

    void delete(String authorization, String id);
}
