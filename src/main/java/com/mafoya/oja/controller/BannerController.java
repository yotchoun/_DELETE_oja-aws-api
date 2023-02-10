package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Banner;
import com.mafoya.oja.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/banners/all")
    public List<Banner> findAll(@RequestHeader("authorization") String authorization) {
        return this.bannerService.getAll(authorization);
    }

    @GetMapping("/banners/{id}")
    public Optional<Banner> getBannerById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.bannerService.getById(authorization, id);

    }

    @PostMapping("/banners")
    public Banner createBanner(@RequestBody @Valid Banner bannerDto, @RequestHeader("authorization") String authorization) {
        return this.bannerService.create(authorization, bannerDto);
    }

    @PutMapping("/banners/{id}")
    public Banner updateBanner(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Banner banner) {
        return this.bannerService.update(authorization, banner, id);


    }

    @DeleteMapping("/banners/{id}")
    public void deleteBanner(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.bannerService.delete(authorization, id);
    }
}

