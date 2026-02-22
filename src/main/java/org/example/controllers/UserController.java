package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.model.UserModel;
import org.example.services.IPService;
import org.example.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    public final UserService userService;
    public final IPService ipService;

    public UserController(UserService userService, IPService ipService) {
        this.userService = userService;
        this.ipService = ipService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) {
        UserModel user = userService.getUser(id);
        if (user == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserModel user, HttpServletRequest request) {
        //get IP address
        String userIp = ipService.getRemoteIP(request);
        userService.addUser(user, userIp);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return  ResponseEntity.noContent().build();
    }
}
