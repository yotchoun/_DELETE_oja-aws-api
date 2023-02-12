package com.mafoya.oja.service;

import com.mafoya.oja.dto.UserContactDto;

import java.util.List;

public interface UserContactService {
    UserContactDto create(String authorization, UserContactDto userContactDto);

    UserContactDto update(String authorization, UserContactDto userContactDto, String id);

    UserContactDto getById(String authorization, String id);

    List<UserContactDto> getAll(String authorization);

    void delete(String authorization, String id);
}
