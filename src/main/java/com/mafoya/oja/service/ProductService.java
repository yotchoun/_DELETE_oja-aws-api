package com.mafoya.oja.service;

import com.mafoya.oja.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto create(String authorization, ProductDto productDto);

    ProductDto update(String authorization, ProductDto productDto, String id);

    ProductDto getById(String authorization, String id);

    List<ProductDto> getAll(String authorization);

    void delete(String authorization, String id);
}
