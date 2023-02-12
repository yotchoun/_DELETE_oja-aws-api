package com.mafoya.oja.service;

import com.mafoya.oja.dto.SocialLinkDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.SocialLink;
import com.mafoya.oja.model.SocialLink;
import com.mafoya.oja.repository.SocialLinkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SocialLinkServiceImpl  implements SocialLinkService {

    private final SocialLinkRepository socialLinkRepository;

    public SocialLinkServiceImpl(SocialLinkRepository socialLinkRepository) {
        this.socialLinkRepository = socialLinkRepository;
    }

    @Override
    public SocialLinkDto getById(String authorization, String id) {
        SocialLinkDto socialLinkDto;
        Optional<SocialLink> socialLinkOptional = socialLinkRepository.findById(id);
        if (socialLinkOptional.isPresent()) {
            socialLinkDto = OjaMapper.mapSocialLinkDto(socialLinkOptional.get());
            return socialLinkDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public SocialLinkDto create(String authorization, SocialLinkDto socialLinkDto) {
        SocialLink socialLink = OjaMapper.mapSocialLinkDo(socialLinkDto);
        socialLinkRepository.save(socialLink);
        return socialLinkDto;
    }

    @Override
    public SocialLinkDto update(String authorization, SocialLinkDto socialLinkDto, String id) {
        Optional<SocialLink> socialLinkOptional = socialLinkRepository.findById(id);
        if (socialLinkOptional.isPresent()) {
            SocialLink socialLink = OjaMapper.mapSocialLinkDo(socialLinkDto);
            socialLink.setId(id);
            socialLinkRepository.save(socialLink);
            return socialLinkDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<SocialLinkDto> getAll(String authorization) {
        List<SocialLink> doList = (List<SocialLink>) socialLinkRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        socialLinkRepository.deleteById(id);
    }
}
