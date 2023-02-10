package com.mafoya.oja.service;

import com.mafoya.oja.model.UserContact;
import com.mafoya.oja.repository.UserContactRepository;

import java.util.List;
import java.util.Optional;

public class UserContactServiceImpl  implements UserContactService {

    private final UserContactRepository userContactRepository;

    public UserContactServiceImpl(UserContactRepository userContactRepository) {
        this.userContactRepository = userContactRepository;
    }

    @Override
    public UserContact create(String authorization, UserContact userContact) {
        return userContactRepository.save(userContact);
    }

    @Override
    public UserContact update(String authorization, UserContact userContact, String id) {
        return userContactRepository.save(userContact);
    }

    @Override
    public Optional<UserContact> getById(String authorization, String id) {
        return userContactRepository.findById(id);
    }

    @Override
    public List<UserContact> getAll(String authorization) {
        return (List<UserContact>) userContactRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        userContactRepository.deleteById(id);
    }
}

