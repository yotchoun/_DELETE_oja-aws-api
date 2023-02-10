package com.mafoya.oja.service;

import com.mafoya.oja.model.Image;
import com.mafoya.oja.repository.ImageRepository;

import java.util.List;
import java.util.Optional;

public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image create(String authorization, Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image update(String authorization, Image image, String id) {
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> getById(String authorization, String id) {
        return imageRepository.findById(id);
    }

    @Override
    public List<Image> getAll(String authorization) {
        return (List<Image>) imageRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        imageRepository.deleteById(id);
    }
}

