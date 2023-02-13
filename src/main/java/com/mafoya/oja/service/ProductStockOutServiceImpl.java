package com.mafoya.oja.service;

import com.mafoya.oja.dto.ProductStockOutDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.ProductStockOut;
import com.mafoya.oja.repository.ProductStockOutRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductStockOutServiceImpl  implements ProductStockOutService {

    private final ProductStockOutRepository productStockOutRepository;

    public ProductStockOutServiceImpl(ProductStockOutRepository productStockOutRepository) {
        this.productStockOutRepository = productStockOutRepository;
    }

    @Override
    public ProductStockOutDto getById(String authorization, String id) {
        ProductStockOutDto productStockOutDto;
        Optional<ProductStockOut> productStockOutOptional = productStockOutRepository.findById(id);
        if (productStockOutOptional.isPresent()) {
            productStockOutDto = OjaMapper.mapProductStockOutDto(productStockOutOptional.get());
            return productStockOutDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ProductStockOutDto create(String authorization, ProductStockOutDto productStockOutDto) {
        ProductStockOut productStockOut = OjaMapper.mapProductStockOutDo(productStockOutDto);
        productStockOutRepository.save(productStockOut);
        return productStockOutDto;
    }

    @Override
    public ProductStockOutDto update(String authorization, ProductStockOutDto productStockOutDto, String id) {
        Optional<ProductStockOut> productStockOutOptional = productStockOutRepository.findById(id);
        if (productStockOutOptional.isPresent()) {
            ProductStockOut productStockOut = OjaMapper.mapProductStockOutDo(productStockOutDto);
            productStockOut.setId(id);
            productStockOutRepository.save(productStockOut);
            return productStockOutDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ProductStockOutDto> getAll(String authorization) {
        List<ProductStockOut> doList = (List<ProductStockOut>) productStockOutRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        productStockOutRepository.deleteById(id);
    }
}

