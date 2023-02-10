package com.mafoya.oja.service;

import com.mafoya.oja.model.ShopService;

import java.util.List;
import java.util.Optional;

public class ShopServiceServiceImpl implements ShopServiceService {
    @Override
    public ShopService create(String authorization, ShopService shopService) {
        return null;
    }

    @Override
    public ShopService update(String authorization, ShopService shopService, String id) {
        return null;
    }

    @Override
    public Optional<ShopService> getById(String authorization, String id) {
        return Optional.empty();
    }

    @Override
    public List<ShopService> getAll(String authorization) {
        return null;
    }

    @Override
    public void delete(String authorization, String id) {

    }
}
