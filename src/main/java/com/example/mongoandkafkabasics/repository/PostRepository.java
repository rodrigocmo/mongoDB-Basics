package com.example.mongoandkafkabasics.repository;

import com.example.mongoandkafkabasics.db.Post;
import com.example.mongoandkafkabasics.db.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    List<Post> findByTitleContaining(String name);
}
