package com.mafoya.oja.service;

import com.mafoya.oja.model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image create(String authorization, Image image);

    Image update(String authorization, Image image, String id);

    Optional<Image> getById(String authorization, String id);

    List<Image> getAll(String authorization);

    void delete(String authorization, String id);
}
