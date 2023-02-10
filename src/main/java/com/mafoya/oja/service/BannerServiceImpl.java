package com.mafoya.oja.service;

import com.mafoya.oja.model.Banner;
import com.mafoya.oja.repository.BannerRepository;

import java.util.List;
import java.util.Optional;

public class BannerServiceImpl  implements BannerService {

    private final BannerRepository bannerRepository;

    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public Banner create(String authorization, Banner banner) {
        return bannerRepository.save(banner);
    }

    @Override
    public Banner update(String authorization, Banner banner, String id) {
        return bannerRepository.save(banner);
    }

    @Override
    public Optional<Banner> getById(String authorization, String id) {
        return bannerRepository.findById(id);
    }

    @Override
    public List<Banner> getAll(String authorization) {
        return (List<Banner>) bannerRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        bannerRepository.deleteById(id);
    }
}

