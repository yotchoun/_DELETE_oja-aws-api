package com.mafoya.oja.service;

import com.mafoya.oja.model.Product;
import com.mafoya.oja.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl  implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(String authorization, Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(String authorization, Product product, String id) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getById(String authorization, String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll(String authorization) {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        productRepository.deleteById(id);
    }
}
