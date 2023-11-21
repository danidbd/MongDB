package com.example.mongodb.config;

import com.example.mongodb.domain.User;
import com.example.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userReposiroty;

    @Override
    public void run(String... arg0) throws Exception {

        userReposiroty.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
    }
}
