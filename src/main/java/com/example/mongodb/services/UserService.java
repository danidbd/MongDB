package com.example.mongodb.services;

import com.example.mongodb.domain.User;
import com.example.mongodb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll (){
        return repo.findAll();
    }

}
