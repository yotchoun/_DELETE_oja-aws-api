package com.mafoya.oja.service;

import com.mafoya.oja.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    Message create(String authorization, Message message);

    Message update(String authorization, Message message, String id);

    Optional<Message> getById(String authorization, String id);

    List<Message> getAll(String authorization);

    void delete(String authorization, String id);
}
