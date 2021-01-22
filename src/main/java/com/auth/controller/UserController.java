package com.auth.controller;

import com.auth.entity.User;
import com.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    private BCryptPasswordEncoder bCrypt;

    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        user.setPassword(bCrypt.encode(user.getPassword()));
        return service.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.getUsers();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }
}
