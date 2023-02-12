package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.ImageDto;
import com.mafoya.oja.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ImageController{

    @Autowired
    private ImageService imageService;

    @GetMapping("/images/all")
    public List<ImageDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.imageService.getAll(authorization);
    }

    @GetMapping("/images/{id}")
    public ImageDto getImageById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.imageService.getById(authorization, id);

    }

    @PostMapping("/images")
    public ImageDto createImage(@RequestBody @Valid ImageDto imageDto, @RequestHeader("authorization") String authorization) {
        return this.imageService.create(authorization, imageDto);
    }

    @PutMapping("/images/{id}")
    public ImageDto updateImage(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ImageDto imageDto) {
        return this.imageService.update(authorization, imageDto, id);


    }

    @DeleteMapping("/images/{id}")
    public void deleteImage(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.imageService.delete(authorization, id);
    }
}

