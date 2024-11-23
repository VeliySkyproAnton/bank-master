package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.model.User;
import com.stepintoprofession.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody @Validated User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
