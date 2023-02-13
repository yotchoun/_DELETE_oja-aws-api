package com.mafoya.oja.service;

import com.mafoya.oja.dto.ImageDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Image;
import com.mafoya.oja.repository.ImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageDto getById(String authorization, String id) {
        ImageDto imageDto;
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            imageDto = OjaMapper.mapImageDto(imageOptional.get());
            return imageDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ImageDto create(String authorization, ImageDto imageDto) {
        Image image = OjaMapper.mapImageDo(imageDto);
        imageRepository.save(image);
        return imageDto;
    }

    @Override
    public ImageDto update(String authorization, ImageDto imageDto, String id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = OjaMapper.mapImageDo(imageDto);
            image.setId(id);
            imageRepository.save(image);
            return imageDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ImageDto> getAll(String authorization) {
        List<Image> doList = (List<Image>) imageRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        imageRepository.deleteById(id);
    }
}

