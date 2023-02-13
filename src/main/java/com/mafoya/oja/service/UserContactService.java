package com.mafoya.oja.service;

import com.mafoya.oja.dto.UserContactDto;

import java.util.List;
import java.util.Set;

public interface UserContactService {
    UserContactDto create(String authorization, UserContactDto userContactDto);

    UserContactDto update(String authorization, UserContactDto userContactDto, String id);

    UserContactDto getById(String authorization, String id);

    List<UserContactDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<UserContactDto> findByUserId(String authorization,String id);
}
