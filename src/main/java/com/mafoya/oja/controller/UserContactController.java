package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.UserContactDto;
import com.mafoya.oja.service.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UserContactController {

    @Autowired
    private UserContactService userContactService;

    @GetMapping("/userContacts/all")
    public List<UserContactDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.userContactService.getAll(authorization);
    }

    @GetMapping("/userContacts/{id}")
    public UserContactDto getUserContactById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.userContactService.getById(authorization, id);

    }

    @PostMapping("/userContacts")
    public UserContactDto createUserContact(@RequestBody @Valid UserContactDto userContactDto, @RequestHeader("authorization") String authorization) {
        return this.userContactService.create(authorization, userContactDto);
    }

    @PutMapping("/userContacts/{id}")
    public UserContactDto updateUserContact(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody UserContactDto userContactDto) {
        return this.userContactService.update(authorization, userContactDto, id);


    }

    @DeleteMapping("/userContacts/{id}")
    public void deleteUserContact(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.userContactService.delete(authorization, id);
    }
}

