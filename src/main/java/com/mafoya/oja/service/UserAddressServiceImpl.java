package com.mafoya.oja.service;

import com.mafoya.oja.dto.UserAddressDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.UserAddress;
import com.mafoya.oja.repository.UserAddressRepository;

import java.util.*;
import java.util.stream.Collectors;

public class UserAddressServiceImpl  implements UserAddressService {

    private final UserAddressRepository userAddressRepository;

    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public UserAddressDto getById(String authorization, String id) {
        UserAddressDto userAddressDto;
        Optional<UserAddress> userAddressOptional = userAddressRepository.findById(id);
        if (userAddressOptional.isPresent()) {
            userAddressDto = OjaMapper.mapUserAddressDto(userAddressOptional.get());
            return userAddressDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public UserAddressDto create(String authorization, UserAddressDto userAddressDto) {
        UserAddress userAddress = OjaMapper.mapUserAddressDo(userAddressDto);
        userAddressRepository.save(userAddress);
        return userAddressDto;
    }

    @Override
    public UserAddressDto update(String authorization, UserAddressDto userAddressDto, String id) {
        Optional<UserAddress> userAddressOptional = userAddressRepository.findById(id);
        if (userAddressOptional.isPresent()) {
            UserAddress userAddress = OjaMapper.mapUserAddressDo(userAddressDto);
            userAddress.setId(id);
            userAddressRepository.save(userAddress);
            return userAddressDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<UserAddressDto> getAll(String authorization) {
        List<UserAddress> doList = (List<UserAddress>) userAddressRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        userAddressRepository.deleteById(id);
    }

    @Override
    public Set<UserAddressDto> findByUserId(String authorization,String id) {
        List<UserAddress> doList = (List<UserAddress>) userAddressRepository.findByUserId(id);
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

