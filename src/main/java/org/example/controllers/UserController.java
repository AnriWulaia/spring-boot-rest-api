package org.example.controllers;

import org.apache.catalina.User;
import org.apache.coyote.http11.HttpOutputBuffer;
import org.example.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class UserController {

    public Map<String, UserModel> userMap = new HashMap<>();

    public UserController() {
        userMap.put("John", new UserModel("John","Doe", 1112));
        userMap.put("Jane", new UserModel("Jane","Duh", 2231));
    }

    @GetMapping("/getUser")
    public ResponseEntity<UserModel> getUser(@RequestParam("name") String name) {
        if (userMap.containsKey(name)) {
            return new ResponseEntity<>(userMap.get(name), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserModel user) {
        userMap.put(user.getFirstName(),  user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam("name") String name) {
        userMap.remove(name);
        return  ResponseEntity.noContent().build();
    }
}
