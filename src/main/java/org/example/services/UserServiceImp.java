package org.example.services;

import org.example.model.UserModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Primary
public class UserServiceImp implements UserService {

    public Map<String, UserModel> userMap = new HashMap<>();

    public UserServiceImp(){
        userMap.put("John", new UserModel("John","Doe", 1112));
        userMap.put("Jane", new UserModel("Jane","Duh", 2231));
    }

    public UserModel getUser(String name){
        return userMap.get(name);
    }

    public void addUser(UserModel user){
        userMap.put(user.getFirstName(), user);
    }

    public void removeUser(String name){
        userMap.remove(name);
    }

}
