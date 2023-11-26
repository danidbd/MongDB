package com.example.mongodb.resouces;

import com.example.mongodb.domain.Post;
import com.example.mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResouce  {
    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity <Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }
}
