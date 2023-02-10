package com.mafoya.oja.service;

import com.mafoya.oja.model.ProductStockOut;

import java.util.List;
import java.util.Optional;

public interface ProductStockOutService {
    ProductStockOut create(String authorization, ProductStockOut productStockOut);

    ProductStockOut update(String authorization, ProductStockOut productStockOut, String id);

    Optional<ProductStockOut> getById(String authorization, String id);

    List<ProductStockOut> getAll(String authorization);

    void delete(String authorization, String id);
}
