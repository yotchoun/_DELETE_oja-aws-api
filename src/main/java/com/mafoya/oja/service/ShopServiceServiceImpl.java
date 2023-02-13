package com.mafoya.oja.service;

import com.mafoya.oja.dto.ShopServiceObjectDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.ShopServiceObject;
import com.mafoya.oja.repository.ShopServiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShopServiceServiceImpl implements ShopServiceService {

    private final ShopServiceRepository shopServiceRepository;

    public ShopServiceServiceImpl(ShopServiceRepository shopServiceRepository) {
        this.shopServiceRepository = shopServiceRepository;
    }

    @Override
    public ShopServiceObjectDto getById(String authorization, String id) {
        ShopServiceObjectDto shopServiceObjectDto;
        Optional<ShopServiceObject> shopServiceObjectOptional = shopServiceRepository.findById(id);
        if (shopServiceObjectOptional.isPresent()) {
            shopServiceObjectDto = OjaMapper.mapShopServiceObjectDto(shopServiceObjectOptional.get());
            return shopServiceObjectDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ShopServiceObjectDto create(String authorization, ShopServiceObjectDto shopServiceObjectDto) {
        ShopServiceObject shopServiceObject = OjaMapper.mapShopServiceObjectDo(shopServiceObjectDto);
        shopServiceRepository.save(shopServiceObject);
        return shopServiceObjectDto;
    }

    @Override
    public ShopServiceObjectDto update(String authorization, ShopServiceObjectDto shopServiceObjectDto, String id) {
        Optional<ShopServiceObject> shopServiceObjectOptional = shopServiceRepository.findById(id);
        if (shopServiceObjectOptional.isPresent()) {
            ShopServiceObject shopServiceObject = OjaMapper.mapShopServiceObjectDo(shopServiceObjectDto);
            shopServiceObject.setId(id);
            shopServiceRepository.save(shopServiceObject);
            return shopServiceObjectDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ShopServiceObjectDto> getAll(String authorization) {
        List<ShopServiceObject> doList = (List<ShopServiceObject>) shopServiceRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        shopServiceRepository.deleteById(id);
    }
}
