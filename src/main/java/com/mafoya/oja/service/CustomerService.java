package com.mafoya.oja.service;

import com.mafoya.oja.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer create(String authorization, Customer customer);
    Customer update(String authorization,Customer customer, String id);
    Optional<Customer> getById(String authorization, String id);
    List<Customer> getAll(String authorization);
    void delete(String authorization,String id);
}
