package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.UserDto;
import com.mafoya.oja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/all")
    public List<UserDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.userService.getAll(authorization);
    }

    @GetMapping("/users/{id}")
    public UserDto getCustomerById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.userService.getById(authorization, id);

    }

    @PostMapping("/users")
    public UserDto createCustomer(@RequestHeader("authorization") String authorization, @RequestBody UserDto userDto) {
        return this.userService.create(authorization, userDto);
    }

    @PutMapping("/users/{id}")
    public UserDto updateCustomer(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody UserDto userDto) {
        return this.userService.update(authorization, userDto, id);


    }

    @DeleteMapping("/users/{id}")
    public void deleteCustomer(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.userService.delete(authorization, id);
    }
}
