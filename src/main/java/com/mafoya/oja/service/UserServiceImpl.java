package com.mafoya.oja.service;

import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.model.User;
import com.mafoya.oja.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository customerRepository;

    public UserServiceImpl(UserRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public User create(String authorization, User customer) {
        return customerRepository.save(customer);
    }

    @Override
    public User update(String authorization, User customer, String id) {

        Optional<User> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            customerOptional.get().setName(customer.getName());
//            customerOptional.get().setCustomerID(customer.getCustomerID());
//            customerOptional.get().setEmail(customer.getEmail());

            return customerRepository.save(customerOptional.get());
        }
        throw new DataNotFoundException("Customer Id not found");
    }

    @Override
    public Optional<User> getById(String authorization, String id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<User> getAll(String authorization) {
        return (List<User>) customerRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        customerRepository.deleteById(id);
    }

}
