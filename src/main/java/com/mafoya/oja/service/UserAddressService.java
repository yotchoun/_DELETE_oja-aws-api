package com.mafoya.oja.service;

import com.mafoya.oja.dto.UserAddressDto;

import java.util.List;
import java.util.Set;

public interface UserAddressService {
    UserAddressDto create(String authorization, UserAddressDto userAddressDto);

    UserAddressDto update(String authorization, UserAddressDto userAddressDto, String id);

    UserAddressDto getById(String authorization, String id);

    List<UserAddressDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<UserAddressDto> findByUserId(String authorization,String id);
}
