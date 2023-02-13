package com.mafoya.oja.service;

import com.mafoya.oja.dto.MessageDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Message;
import com.mafoya.oja.repository.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MessageServiceImpl  implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageDto getById(String authorization, String id) {
        MessageDto messageDto;
        Optional<Message> messageOptional = messageRepository.findById(id);
        if (messageOptional.isPresent()) {
            messageDto = OjaMapper.mapMessageDto(messageOptional.get());
            return messageDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public MessageDto create(String authorization, MessageDto messageDto) {
        Message message = OjaMapper.mapMessageDo(messageDto);
        messageRepository.save(message);
        return messageDto;
    }

    @Override
    public MessageDto update(String authorization, MessageDto messageDto, String id) {
        Optional<Message> messageOptional = messageRepository.findById(id);
        if (messageOptional.isPresent()) {
            Message message = OjaMapper.mapMessageDo(messageDto);
            message.setId(id);
            messageRepository.save(message);
            return messageDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<MessageDto> getAll(String authorization) {
        List<Message> doList = (List<Message>) messageRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        messageRepository.deleteById(id);
    }
}

