package com.mafoya.oja.service;

import com.mafoya.oja.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product create(String authorization, Product product);

    Product update(String authorization, Product product, String id);

    Optional<Product> getById(String authorization, String id);

    List<Product> getAll(String authorization);

    void delete(String authorization, String id);
}
