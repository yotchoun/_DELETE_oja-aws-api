package com.mafoya.oja.service;

import com.mafoya.oja.dto.BrandDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Brand;
import com.mafoya.oja.repository.BrandRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandDto getById(String authorization, String id) {
        BrandDto brandDto;
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if (brandOptional.isPresent()) {
            brandDto = OjaMapper.mapBrandDto(brandOptional.get());
            return brandDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public BrandDto create(String authorization, BrandDto brandDto) {
        Brand brand = OjaMapper.mapBrandDo(brandDto);
        brandRepository.save(brand);
        return brandDto;
    }

    @Override
    public BrandDto update(String authorization, BrandDto brandDto, String id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if (brandOptional.isPresent()) {
            Brand brand = OjaMapper.mapBrandDo(brandDto);
            brand.setId(id);
            brandRepository.save(brand);
            return brandDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<BrandDto> getAll(String authorization) {
        List<Brand> doList = (List<Brand>) brandRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        brandRepository.deleteById(id);
    }
}
