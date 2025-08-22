package com.rohit.service;

import com.rohit.exception.UserException;
import com.rohit.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers();
    void deleteUser(Long id) throws UserException;
    User updateUser(Long id , User user) throws UserException;
}
