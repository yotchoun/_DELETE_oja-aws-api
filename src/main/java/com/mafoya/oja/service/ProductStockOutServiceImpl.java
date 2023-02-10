package com.mafoya.oja.service;

import com.mafoya.oja.model.ProductStockOut;
import com.mafoya.oja.repository.ProductStockOutRepository;

import java.util.List;
import java.util.Optional;

public class ProductStockOutServiceImpl  implements ProductStockOutService {

    private final ProductStockOutRepository productStockOutRepository;

    public ProductStockOutServiceImpl(ProductStockOutRepository productStockOutRepository) {
        this.productStockOutRepository = productStockOutRepository;
    }

    @Override
    public ProductStockOut create(String authorization, ProductStockOut productStockOut) {
        return productStockOutRepository.save(productStockOut);
    }

    @Override
    public ProductStockOut update(String authorization, ProductStockOut productStockOut, String id) {
        return productStockOutRepository.save(productStockOut);
    }

    @Override
    public Optional<ProductStockOut> getById(String authorization, String id) {
        return productStockOutRepository.findById(id);
    }

    @Override
    public List<ProductStockOut> getAll(String authorization) {
        return (List<ProductStockOut>) productStockOutRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        productStockOutRepository.deleteById(id);
    }
}

