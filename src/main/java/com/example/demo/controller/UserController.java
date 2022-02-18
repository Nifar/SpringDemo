package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public void createRole(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }

}
