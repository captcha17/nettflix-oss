package com.rakushev.msuser.controller;

import com.rakushev.msuser.entity.User;
import com.rakushev.msuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/member")
    public ResponseEntity<Iterable<User>> getAll() {
        Iterable<User> all = userService.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("/member")
    public ResponseEntity<User> register(@RequestBody User input) {
        User result = userService.registerUser(input);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
