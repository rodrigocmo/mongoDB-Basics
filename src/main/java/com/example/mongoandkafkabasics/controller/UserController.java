package com.example.mongoandkafkabasics.controller;

import com.example.mongoandkafkabasics.db.User;
import com.example.mongoandkafkabasics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
