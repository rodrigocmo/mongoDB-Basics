package com.example.mongoandkafkabasics.repository;

import com.example.mongoandkafkabasics.db.Post;
import com.example.mongoandkafkabasics.db.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    List<Post> findByTitleContaining(String title);
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    // check de doc to understand how to use this query 
    List<Post> findByTitle(String title);
}
