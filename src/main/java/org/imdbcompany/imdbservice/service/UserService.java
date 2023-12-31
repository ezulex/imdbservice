package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    void deleteUserById(long id);
}
