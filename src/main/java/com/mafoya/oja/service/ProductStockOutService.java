package com.mafoya.oja.service;

import com.mafoya.oja.dto.ProductStockOutDto;

import java.util.List;

public interface ProductStockOutService {
    ProductStockOutDto create(String authorization, ProductStockOutDto productStockOutDto);

    ProductStockOutDto update(String authorization, ProductStockOutDto productStockOutDto, String id);

    ProductStockOutDto getById(String authorization, String id);

    List<ProductStockOutDto> getAll(String authorization);

    void delete(String authorization, String id);
}
