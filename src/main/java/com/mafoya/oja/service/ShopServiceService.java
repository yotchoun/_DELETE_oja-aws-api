package com.mafoya.oja.service;

import com.mafoya.oja.dto.ShopServiceObjectDto;

import java.util.List;

public interface ShopServiceService {
    ShopServiceObjectDto create(String authorization, ShopServiceObjectDto shopServiceObjectDto);

    ShopServiceObjectDto update(String authorization, ShopServiceObjectDto shopServiceObjectDto, String id);

    ShopServiceObjectDto getById(String authorization, String id);

    List<ShopServiceObjectDto> getAll(String authorization);

    void delete(String authorization, String id);
}
