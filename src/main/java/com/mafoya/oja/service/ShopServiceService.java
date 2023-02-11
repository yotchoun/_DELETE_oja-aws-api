package com.mafoya.oja.service;

import com.mafoya.oja.model.ShopServiceObject;

import java.util.List;
import java.util.Optional;

public interface ShopServiceService {
    ShopServiceObject create(String authorization, ShopServiceObject shopService);

    ShopServiceObject update(String authorization, ShopServiceObject shopService, String id);

    Optional<ShopServiceObject> getById(String authorization, String id);

    List<ShopServiceObject> getAll(String authorization);

    void delete(String authorization, String id);
}
