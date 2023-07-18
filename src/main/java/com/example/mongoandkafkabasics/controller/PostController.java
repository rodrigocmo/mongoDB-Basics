package com.example.mongoandkafkabasics.controller;

import com.example.mongoandkafkabasics.db.Post;
import com.example.mongoandkafkabasics.db.User;
import com.example.mongoandkafkabasics.service.PostService;
import com.example.mongoandkafkabasics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    @Autowired
    private PostService service;
    @Autowired
    private UserService userService;

    @GetMapping(path ="/all")
    public ResponseEntity<List<Post>> findAllPosts(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<List<Post>> findPostByUserId(@PathVariable String id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj.getPost());
    }

    @PostMapping(path="/save")
    public ResponseEntity<Post> saveUser(@RequestBody Post post){
        Post obj = service.savePost(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
        //return new ResponseEntity<>(service.savePost(post), HttpStatus.OK);
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}