package com.example.mongoandkafkabasics.service;

import com.example.mongoandkafkabasics.db.User;
import com.example.mongoandkafkabasics.repository.UserRepository;
import com.example.mongoandkafkabasics.service.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }


    public User findByIds(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new GenericException("Objeto não encontrado"));
    }
}
