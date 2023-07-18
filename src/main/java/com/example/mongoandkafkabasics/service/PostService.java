package com.example.mongoandkafkabasics.service;

import com.example.mongoandkafkabasics.db.Post;
import com.example.mongoandkafkabasics.repository.PostRepository;
import com.example.mongoandkafkabasics.service.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }


    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new GenericException("Post nao encontrado"));

    }

    public Post savePost(Post post){
       return repository.insert(post);
    }

    public void delete(String id){
        Optional<Post> post = repository.findById(id);
        post.ifPresent(value -> repository.delete(value));
    }
}
