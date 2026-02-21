package org.example.services;

import org.example.model.UserModel;

public interface UserService {
    UserModel getUser(String name);
    void addUser(UserModel user, String ipAdress);
    void removeUser(String name);
}
