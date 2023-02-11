package com.mafoya.oja.service;

import com.mafoya.oja.model.Shop;
import com.mafoya.oja.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Shop create(String authorization, Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop update(String authorization, Shop shop, String id) {
        return shopRepository.save(shop);
    }

    @Override
    public Optional<Shop> getById(String authorization, String id) {
        return shopRepository.findById(id);
    }

    @Override
    public List<Shop> getAll(String authorization) {
        return (List<Shop>) shopRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        shopRepository.deleteById(id);
    }
}


