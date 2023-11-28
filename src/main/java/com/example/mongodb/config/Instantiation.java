package com.example.mongodb.config;

import com.example.mongodb.domain.Post;
import com.example.mongodb.domain.User;
import com.example.mongodb.dto.AuthorDTO;
import com.example.mongodb.dto.CommentDTO;
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
        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

        Post post01 = new Post(null, sdf.parse("21/03/2023"), "teste 1", "teste 2", new AuthorDTO(maria));
        Post post02 = new Post(null, sdf.parse("25/09/2023"), "coment 1", "coment 2 ", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post01.getComments().addAll(Arrays.asList(c1, c2));
        post02.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post01, post02));
        maria.getPosts().addAll(Arrays.asList(post01, post02));
        userReposiroty.save(maria);

    }
}
