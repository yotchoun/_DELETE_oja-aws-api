package com.mafoya.oja.service;


import com.mafoya.oja.dto.BannerDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Banner;
import com.mafoya.oja.repository.BannerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BannerServiceImpl  implements BannerService {


    private final BannerRepository bannerRepository;

    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public BannerDto getById(String authorization, String id) {
       BannerDto bannerDto;
        Optional<Banner> bannerOptional = bannerRepository.findById(id);
        if (bannerOptional.isPresent()) {
            bannerDto = OjaMapper.mapBannerDto(bannerOptional.get());
            return bannerDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public BannerDto create(String authorization,BannerDto bannerDto) {
        Banner banner = OjaMapper.mapBannerDo(bannerDto);
        bannerRepository.save(banner);
        return bannerDto;
    }

    @Override
    public BannerDto update(String authorization,BannerDto bannerDto, String id) {
        Optional<Banner> bannerOptional = bannerRepository.findById(id);
        if (bannerOptional.isPresent()) {
            Banner banner = OjaMapper.mapBannerDo(bannerDto);
            banner.setId(id);
            bannerRepository.save(banner);
            return bannerDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<BannerDto> getAll(String authorization) {
        List<Banner> doList = (List<Banner>) bannerRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        bannerRepository.deleteById(id);
    }
}

