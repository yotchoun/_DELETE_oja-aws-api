package com.mafoya.oja.service;

import com.mafoya.oja.model.UserAddress;

import java.util.List;
import java.util.Optional;

public interface UserAddressService {
    UserAddress create(String authorization, UserAddress userAddress);

    UserAddress update(String authorization, UserAddress userAddress, String id);

    Optional<UserAddress> getById(String authorization, String id);

    List<UserAddress> getAll(String authorization);

    void delete(String authorization, String id);
}
