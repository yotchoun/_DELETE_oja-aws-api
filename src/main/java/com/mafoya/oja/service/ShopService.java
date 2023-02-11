package com.mafoya.oja.service;

import com.mafoya.oja.model.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    Shop create(String authorization, Shop shop);

    Shop update(String authorization, Shop shop, String id);

    Optional<Shop> getById(String authorization, String id);

    List<Shop> getAll(String authorization);

    void delete(String authorization, String id);
}
