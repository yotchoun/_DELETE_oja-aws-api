package com.mafoya.oja.service;

import com.mafoya.oja.dto.MessageDto;

import java.util.List;

public interface MessageService {
    MessageDto create(String authorization, MessageDto messageDto);

    MessageDto update(String authorization, MessageDto messageDto, String id);

    MessageDto getById(String authorization, String id);

    List<MessageDto> getAll(String authorization);

    void delete(String authorization, String id);
}
