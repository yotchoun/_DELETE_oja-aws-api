package com.mafoya.oja.service;

import com.mafoya.oja.dto.CustomerDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Customer;
import com.mafoya.oja.model.Customer;
import com.mafoya.oja.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerServiceImpl  implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto getById(String authorization, String id) {
        CustomerDto customerDto;
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            customerDto = OjaMapper.mapCustomerDto(customerOptional.get());
            return customerDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public CustomerDto create(String authorization, CustomerDto customerDto) {
        Customer customer = OjaMapper.mapCustomerDo(customerDto);
        customerRepository.save(customer);
        return customerDto;
    }

    @Override
    public CustomerDto update(String authorization, CustomerDto customerDto, String id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = OjaMapper.mapCustomerDo(customerDto);
            customer.setId(id);
            customerRepository.save(customer);
            return customerDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<CustomerDto> getAll(String authorization) {
        List<Customer> doList = (List<Customer>) customerRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        customerRepository.deleteById(id);
    }
}
