package com.mafoya.oja.service;

import com.mafoya.oja.dto.ShopDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Shop;
import com.mafoya.oja.repository.ShopRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public ShopDto getById(String authorization, String id) {
        ShopDto shopDto;
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if (shopOptional.isPresent()) {
            shopDto = OjaMapper.mapShopDto(shopOptional.get());
            return shopDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ShopDto create(String authorization, ShopDto shopDto) {
        Shop shop = OjaMapper.mapShopDo(shopDto);
        shopRepository.save(shop);
        return shopDto;
    }

    @Override
    public ShopDto update(String authorization, ShopDto shopDto, String id) {
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if (shopOptional.isPresent()) {
            Shop shop = OjaMapper.mapShopDo(shopDto);
            shop.setId(id);
            shopRepository.save(shop);
            return shopDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ShopDto> getAll(String authorization) {
        List<Shop> doList = (List<Shop>) shopRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Set<ShopDto> findByUserId(String authorization,String id) {
        List<Shop> doList = (List<Shop>) shopRepository.findByUserId(id);
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<ShopDto> findBySocialLinkId(String authorization,String id) {
        List<Shop> doList = (List<Shop>) shopRepository.findBySocialLinkId(id);
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }
}


