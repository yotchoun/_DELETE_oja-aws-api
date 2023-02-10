package com.mafoya.oja.service;

import com.mafoya.oja.model.Banner;

import java.util.List;
import java.util.Optional;

public interface BannerService {
    Banner create(String authorization, Banner banner);

    Banner update(String authorization, Banner banner, String id);

    Optional<Banner> getById(String authorization, String id);

    List<Banner> getAll(String authorization);

    void delete(String authorization, String id);
}
