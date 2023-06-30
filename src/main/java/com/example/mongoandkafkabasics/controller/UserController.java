package com.example.mongoandkafkabasics.controller;

import com.example.mongoandkafkabasics.db.User;
import com.example.mongoandkafkabasics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping(path ="/all")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<User> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(path="/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User obj = service.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
        //return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
    }

}
