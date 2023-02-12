package com.mafoya.oja.service;

import com.mafoya.oja.dto.SocialLinkDto;

import java.util.List;

public interface SocialLinkService {
    SocialLinkDto create(String authorization, SocialLinkDto socialLinkDto);

    SocialLinkDto update(String authorization, SocialLinkDto socialLinkDto, String id);

    SocialLinkDto getById(String authorization, String id);

    List<SocialLinkDto> getAll(String authorization);

    void delete(String authorization, String id);
}
