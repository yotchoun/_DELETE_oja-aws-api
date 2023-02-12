package com.mafoya.oja.service;

import com.mafoya.oja.dto.UserAddressDto;

import java.util.List;

public interface UserAddressService {
    UserAddressDto create(String authorization, UserAddressDto userAddressDto);

    UserAddressDto update(String authorization, UserAddressDto userAddressDto, String id);

    UserAddressDto getById(String authorization, String id);

    List<UserAddressDto> getAll(String authorization);

    void delete(String authorization, String id);
}
