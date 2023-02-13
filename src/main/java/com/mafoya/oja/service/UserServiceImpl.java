package com.mafoya.oja.service;

import com.mafoya.oja.dto.UserDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.User;
import com.mafoya.oja.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getById(String authorization, String id) {
        UserDto userDto;
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userDto = OjaMapper.mapUserDto(userOptional.get());
            return userDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public UserDto create(String authorization, UserDto userDto) {
        User user = OjaMapper.mapUserDo(userDto);
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto update(String authorization, UserDto userDto, String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = OjaMapper.mapUserDo(userDto);
            user.setId(id);
            userRepository.save(user);
            return userDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<UserDto> getAll(String authorization) {
        List<User> doList = (List<User>) userRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        userRepository.deleteById(id);
    }

}
