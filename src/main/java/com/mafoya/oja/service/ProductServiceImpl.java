package com.mafoya.oja.service;

import com.mafoya.oja.dto.ProductDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Product;
import com.mafoya.oja.model.Product;
import com.mafoya.oja.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl  implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getById(String authorization, String id) {
        ProductDto productDto;
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productDto = OjaMapper.mapProductDto(productOptional.get());
            return productDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ProductDto create(String authorization, ProductDto productDto) {
        Product product = OjaMapper.mapProductDo(productDto);
        productRepository.save(product);
        return productDto;
    }

    @Override
    public ProductDto update(String authorization, ProductDto productDto, String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = OjaMapper.mapProductDo(productDto);
            product.setId(id);
            productRepository.save(product);
            return productDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ProductDto> getAll(String authorization) {
        List<Product> doList = (List<Product>) productRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        productRepository.deleteById(id);
    }
}
