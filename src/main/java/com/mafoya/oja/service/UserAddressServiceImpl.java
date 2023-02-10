package com.mafoya.oja.service;

import com.mafoya.oja.model.UserAddress;
import com.mafoya.oja.repository.UserAddressRepository;

import java.util.List;
import java.util.Optional;

public class UserAddressServiceImpl  implements UserAddressService {

    private final UserAddressRepository userAddressRepository;

    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public UserAddress create(String authorization, UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public UserAddress update(String authorization, UserAddress userAddress, String id) {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public Optional<UserAddress> getById(String authorization, String id) {
        return userAddressRepository.findById(id);
    }

    @Override
    public List<UserAddress> getAll(String authorization) {
        return (List<UserAddress>) userAddressRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        userAddressRepository.deleteById(id);
    }
}

