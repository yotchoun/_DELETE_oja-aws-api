package com.mafoya.oja.service;

import com.mafoya.oja.model.ShopService;

import java.util.List;
import java.util.Optional;

public interface ShopServiceService {
    ShopService create(String authorization, ShopService shopService);

    ShopService update(String authorization, ShopService shopService, String id);

    Optional<ShopService> getById(String authorization, String id);

    List<ShopService> getAll(String authorization);

    void delete(String authorization, String id);
}
