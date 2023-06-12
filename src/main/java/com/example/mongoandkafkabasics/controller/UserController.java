package com.example.mongoandkafkabasics.controller;

import com.example.mongoandkafkabasics.db.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping(path ="/all")
    public ResponseEntity<User> findAllUsers(){
        User user = new User("nome","teste");
        return ResponseEntity.ok().body(user);
    }

}
