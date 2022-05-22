package com.example.pp_3_1_4_1.service;

import com.example.pp_3_1_4_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(User user);
    User getUserById(Long id);
    void deleteById(Long id);
    User findUserByName(String name);
}
