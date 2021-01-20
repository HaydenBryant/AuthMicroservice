package com.auth.service;

import com.auth.entity.User;
import com.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }

    public User getUserById(int id){
        return repo.findById(id).orElse(null);
    }

}
