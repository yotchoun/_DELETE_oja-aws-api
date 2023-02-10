package com.mafoya.oja.service;

import com.mafoya.oja.model.SocialLink;
import com.mafoya.oja.repository.SocialLinkRepository;

import java.util.List;
import java.util.Optional;

public class SocialLinkServiceImpl  implements SocialLinkService {

    private final SocialLinkRepository socialLinkRepository;

    public SocialLinkServiceImpl(SocialLinkRepository socialLinkRepository) {
        this.socialLinkRepository = socialLinkRepository;
    }

    @Override
    public SocialLink create(String authorization, SocialLink socialLink) {
        return socialLinkRepository.save(socialLink);
    }

    @Override
    public SocialLink update(String authorization, SocialLink socialLink, String id) {
        return socialLinkRepository.save(socialLink);
    }

    @Override
    public Optional<SocialLink> getById(String authorization, String id) {
        return socialLinkRepository.findById(id);
    }

    @Override
    public List<SocialLink> getAll(String authorization) {
        return (List<SocialLink>) socialLinkRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        socialLinkRepository.deleteById(id);
    }
}
