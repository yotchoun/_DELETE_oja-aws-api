package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Message;
import com.mafoya.oja.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages/all")
    public List<Message> findAll(@RequestHeader("authorization") String authorization) {
        return this.messageService.getAll(authorization);
    }

    @GetMapping("/messages/{id}")
    public Optional<Message> getMessageById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.messageService.getById(authorization, id);

    }

    @PostMapping("/messages")
    public Message createMessage(@RequestBody @Valid Message messageDto, @RequestHeader("authorization") String authorization) {
        return this.messageService.create(authorization, messageDto);
    }

    @PutMapping("/messages/{id}")
    public Message updateMessage(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Message message) {
        return this.messageService.update(authorization, message, id);


    }

    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.messageService.delete(authorization, id);
    }
}

