package com.mafoya.oja.service;

import com.mafoya.oja.model.ShopServiceObject;
import com.mafoya.oja.repository.ShopServiceRepository;

import java.util.List;
import java.util.Optional;

public class ShopServiceServiceImpl implements ShopServiceService {

    private final ShopServiceRepository shopServiceRepository;

    public ShopServiceServiceImpl(ShopServiceRepository shopServiceRepository) {
        this.shopServiceRepository = shopServiceRepository;
    }

    @Override
    public ShopServiceObject create(String authorization, ShopServiceObject brand) {
        return shopServiceRepository.save(brand);
    }

    @Override
    public ShopServiceObject update(String authorization, ShopServiceObject brand, String id) {
        return shopServiceRepository.save(brand);
    }

    @Override
    public Optional<ShopServiceObject> getById(String authorization, String id) {
        return shopServiceRepository.findById(id);
    }

    @Override
    public List<ShopServiceObject> getAll(String authorization) {
        return (List<ShopServiceObject>) shopServiceRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        shopServiceRepository.deleteById(id);
    }
}
