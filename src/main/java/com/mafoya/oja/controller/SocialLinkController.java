package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.SocialLinkDto;
import com.mafoya.oja.service.SocialLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class SocialLinkController{

    @Autowired
    private SocialLinkService socialLinkService;

    @GetMapping("/socialLinks/all")
    public List<SocialLinkDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.socialLinkService.getAll(authorization);
    }

    @GetMapping("/socialLinks/{id}")
    public SocialLinkDto getSocialLinkById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.socialLinkService.getById(authorization, id);

    }

    @PostMapping("/socialLinks")
    public SocialLinkDto createSocialLink(@RequestBody @Valid SocialLinkDto socialLinkDto, @RequestHeader("authorization") String authorization) {
        return this.socialLinkService.create(authorization, socialLinkDto);
    }

    @PutMapping("/socialLinks/{id}")
    public SocialLinkDto updateSocialLink(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody SocialLinkDto socialLinkDto) {
        return this.socialLinkService.update(authorization, socialLinkDto, id);


    }

    @DeleteMapping("/socialLinks/{id}")
    public void deleteSocialLink(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.socialLinkService.delete(authorization, id);
    }
}

