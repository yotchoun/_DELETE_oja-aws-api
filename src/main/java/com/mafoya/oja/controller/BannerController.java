package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.BannerDto;
import com.mafoya.oja.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/banners/all")
    public List<BannerDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.bannerService.getAll(authorization);
    }

    @GetMapping("/banners/{id}")
    public BannerDto getBannerById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.bannerService.getById(authorization, id);

    }

    @PostMapping("/banners")
    public BannerDto createBanner(@RequestBody @Valid BannerDto bannerDto, @RequestHeader("authorization") String authorization) {
        return this.bannerService.create(authorization, bannerDto);
    }

    @PutMapping("/banners/{id}")
    public BannerDto updateBanner(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody BannerDto bannerDto) {
        return this.bannerService.update(authorization, bannerDto, id);


    }

    @DeleteMapping("/banners/{id}")
    public void deleteBanner(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.bannerService.delete(authorization, id);
    }
}

