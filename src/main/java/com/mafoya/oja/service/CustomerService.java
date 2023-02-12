package com.mafoya.oja.service;

import com.mafoya.oja.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto create(String authorization, CustomerDto customerDto);

    CustomerDto update(String authorization, CustomerDto customerDto, String id);

    CustomerDto getById(String authorization, String id);

    List<CustomerDto> getAll(String authorization);

    void delete(String authorization, String id);
}
