package com.rakushev.msuser.service;

import com.rakushev.msuser.entity.User;

public interface UserService {
    User registerUser(User user);
    Iterable<User> findAll();
}
