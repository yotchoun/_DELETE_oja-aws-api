package com.mafoya.oja.service;

import com.mafoya.oja.model.Message;
import com.mafoya.oja.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

public class MessageServiceImpl  implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message create(String authorization, Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message update(String authorization, Message message, String id) {
        return messageRepository.save(message);
    }

    @Override
    public Optional<Message> getById(String authorization, String id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> getAll(String authorization) {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        messageRepository.deleteById(id);
    }
}

