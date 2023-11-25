package com.example.mongodb.config;

import com.example.mongodb.domain.Post;
import com.example.mongodb.domain.User;
import com.example.mongodb.repository.PostRepository;
import com.example.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userReposiroty;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userReposiroty.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post01 = new Post(null, sdf.parse("21/11/2023"), "teste 1", "Teste2", maria);
        Post post02 = new Post(null, sdf.parse("25/09/2023"), "coment 1", "coment 2 ", maria);
        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post01, post02));

    }
}
