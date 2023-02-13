package com.mafoya.oja.service;

import com.mafoya.oja.dto.UserContactDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.UserContact;
import com.mafoya.oja.repository.UserContactRepository;

import java.util.*;
import java.util.stream.Collectors;

public class UserContactServiceImpl  implements UserContactService {

    private final UserContactRepository userContactRepository;

    public UserContactServiceImpl(UserContactRepository userContactRepository) {
        this.userContactRepository = userContactRepository;
    }

    @Override
    public UserContactDto getById(String authorization, String id) {
        UserContactDto userContactDto;
        Optional<UserContact> userContactOptional = userContactRepository.findById(id);
        if (userContactOptional.isPresent()) {
            userContactDto = OjaMapper.mapUserContactDto(userContactOptional.get());
            return userContactDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public UserContactDto create(String authorization, UserContactDto userContactDto) {
        UserContact userContact = OjaMapper.mapUserContactDo(userContactDto);
        userContactRepository.save(userContact);
        return userContactDto;
    }

    @Override
    public UserContactDto update(String authorization, UserContactDto userContactDto, String id) {
        Optional<UserContact> userContactOptional = userContactRepository.findById(id);
        if (userContactOptional.isPresent()) {
            UserContact userContact = OjaMapper.mapUserContactDo(userContactDto);
            userContact.setId(id);
            userContactRepository.save(userContact);
            return userContactDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<UserContactDto> getAll(String authorization) {
        List<UserContact> doList = (List<UserContact>) userContactRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        userContactRepository.deleteById(id);
    }

    @Override
    public Set<UserContactDto> findByUserId(String authorization,String id) {
        List<UserContact> doList = (List<UserContact>) userContactRepository.findByUserId(id);
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

