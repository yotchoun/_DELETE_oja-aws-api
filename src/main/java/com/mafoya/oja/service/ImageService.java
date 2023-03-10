package com.mafoya.oja.service;

import com.mafoya.oja.dto.ImageDto;

import java.util.List;
import java.util.Set;

public interface ImageService {
    ImageDto create(String authorization, ImageDto imageDto);

    ImageDto update(String authorization, ImageDto imageDto, String id);

    ImageDto getById(String authorization, String id);

    List<ImageDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<ImageDto> findByProductId(String authorization,String id);
}
