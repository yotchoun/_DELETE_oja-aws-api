package com.mafoya.oja.service;

import com.mafoya.oja.model.Brand;
import com.mafoya.oja.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(String authorization, Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(String authorization, Brand brand, String id) {
        return brandRepository.save(brand);
    }

    @Override
    public Optional<Brand> getById(String authorization, String id) {
        return brandRepository.findById(id);
    }

    @Override
    public List<Brand> getAll(String authorization) {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        brandRepository.deleteById(id);
    }
}
