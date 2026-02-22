package org.example.services;

import org.example.model.UserModel;

public interface UserService {
    UserModel getUser(Long id);
    void addUser(UserModel user, String ipAdress);
    void removeUser(Long id);
}
