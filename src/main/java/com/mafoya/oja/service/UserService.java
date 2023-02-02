package com.mafoya.oja.service;

import com.mafoya.oja.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(String authorization, User customer);
    User update(String authorization, User customer, String id);
    Optional<User> getById(String authorization, String id);
    List<User> getAll(String authorization);
    void delete(String authorization,String id);
}
