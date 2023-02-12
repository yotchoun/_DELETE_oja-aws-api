package com.mafoya.oja.service;

import com.mafoya.oja.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto create(String authorization, UserDto userDto);
    UserDto update(String authorization, UserDto userDto, String id);
    UserDto getById(String authorization, String id);
    List<UserDto> getAll(String authorization);
    void delete(String authorization,String id);
}
