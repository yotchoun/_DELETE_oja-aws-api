package com.mafoya.oja.service;

import com.mafoya.oja.dto.BannerDto;

import java.util.List;

public interface BannerService {
    BannerDto create(String authorization, BannerDto bannerDto);

    BannerDto update(String authorization, BannerDto bannerDto, String id);

    BannerDto getById(String authorization, String id);

    List<BannerDto> getAll(String authorization);

    void delete(String authorization, String id);
}
