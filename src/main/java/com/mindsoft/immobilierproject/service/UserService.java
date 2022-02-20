package com.mindsoft.immobilierproject.service;

import java.util.List;

import com.mindsoft.immobilierproject.model.Role;
import com.mindsoft.immobilierproject.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    List<Role> getRoles();
}
