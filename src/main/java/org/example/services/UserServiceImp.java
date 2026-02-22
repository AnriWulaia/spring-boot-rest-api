package org.example.services;

import org.example.model.UserModel;
import org.example.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Primary
public class UserServiceImp implements UserService {

    private final TimeService timeService;
    private final UserRepository userRepository;


    public UserServiceImp(TimeService timeService, UserRepository userRepository) {
        this.timeService = timeService;
        this.userRepository = userRepository;
    }

    @Override
    public UserModel getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void addUser(UserModel user, String ipAddress) {
        user.setCreatedAt(timeService.getCurrentTime(ipAddress));
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
    }

}
