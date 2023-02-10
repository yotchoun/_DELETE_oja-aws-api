package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Image;
import com.mafoya.oja.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ImageController{

    @Autowired
    private ImageService imageService;

    @GetMapping("/images/all")
    public List<Image> findAll(@RequestHeader("authorization") String authorization) {
        return this.imageService.getAll(authorization);
    }

    @GetMapping("/images/{id}")
    public Optional<Image> getImageById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.imageService.getById(authorization, id);

    }

    @PostMapping("/images")
    public Image createImage(@RequestBody @Valid Image imageDto, @RequestHeader("authorization") String authorization) {
        return this.imageService.create(authorization, imageDto);
    }

    @PutMapping("/images/{id}")
    public Image updateImage(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Image image) {
        return this.imageService.update(authorization, image, id);


    }

    @DeleteMapping("/images/{id}")
    public void deleteImage(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.imageService.delete(authorization, id);
    }
}

