package com.mafoya.oja.service;

import com.mafoya.oja.model.SocialLink;

import java.util.List;
import java.util.Optional;

public interface SocialLinkService {
    SocialLink create(String authorization, SocialLink socialLink);

    SocialLink update(String authorization, SocialLink socialLink, String id);

    Optional<SocialLink> getById(String authorization, String id);

    List<SocialLink> getAll(String authorization);

    void delete(String authorization, String id);
}
