package com.mafoya.oja.service;

import com.mafoya.oja.model.Customer;
import com.mafoya.oja.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl  implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(String authorization, Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(String authorization, Customer customer, String id) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getById(String authorization, String id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAll(String authorization) {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        customerRepository.deleteById(id);
    }
}
