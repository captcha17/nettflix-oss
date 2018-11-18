package com.rakushev.msuser.service;

import com.rakushev.msuser.entity.User;
import com.rakushev.msuser.kafka.producer.Sender;
import com.rakushev.msuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Value("${spring.kafka.topic.userCreated}")
    private static String USER_CREATED_TOPIC;

    private UserRepository userRepository;
    private Sender sender;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Sender sender) {
        this.userRepository = userRepository;
        this.sender = sender;
    }

    @Override
    public User registerUser(User input) {
        User createdUser = userRepository.save(input);
        sender.send(USER_CREATED_TOPIC, createdUser);
        return createdUser;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
