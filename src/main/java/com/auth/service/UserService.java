package com.auth.service;

import com.auth.entity.User;
import com.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }

    public User getUserById(int id){
        return repo.findById(id).orElse(null);
    }

    public List<User> getUsers(){
        return repo.findAll();
    }

    public void deleteUser(int id){
        repo.deleteById(id);
    }

    public User updateUser(User user){
        User existingUser = repo.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return repo.save(existingUser);
    }

}
