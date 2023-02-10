package com.mafoya.oja.service;

import com.mafoya.oja.model.ShopService;
import com.mafoya.oja.model.ShopService;
import com.mafoya.oja.repository.ShopServiceRepository;

import java.util.List;
import java.util.Optional;

public class ShopServiceServiceImpl  implements ShopServiceService {

    private final ShopServiceRepository brandRepository;

    public ShopServiceServiceImpl(ShopServiceRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public ShopService create(String authorization, ShopService brand) {
        return brandRepository.save(brand);
    }

    @Override
    public ShopService update(String authorization, ShopService brand, String id) {
        return brandRepository.save(brand);
    }

    @Override
    public Optional<ShopService> getById(String authorization, String id) {
        return brandRepository.findById(id);
    }

    @Override
    public List<ShopService> getAll(String authorization) {
        return (List<ShopService>) brandRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        brandRepository.deleteById(id);
    }
}
