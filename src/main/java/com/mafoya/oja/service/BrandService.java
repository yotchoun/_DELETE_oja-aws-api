package com.mafoya.oja.service;

import com.mafoya.oja.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    Brand create(String authorization, Brand brand);

    Brand update(String authorization, Brand brand, String id);

    Optional<Brand> getById(String authorization, String id);

    List<Brand> getAll(String authorization);

    void delete(String authorization, String id);
}
