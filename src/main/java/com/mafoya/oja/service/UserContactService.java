package com.mafoya.oja.service;

import com.mafoya.oja.model.UserContact;

import java.util.List;
import java.util.Optional;

public interface UserContactService {
    UserContact create(String authorization, UserContact userContact);

    UserContact update(String authorization, UserContact userContact, String id);

    Optional<UserContact> getById(String authorization, String id);

    List<UserContact> getAll(String authorization);

    void delete(String authorization, String id);
}
