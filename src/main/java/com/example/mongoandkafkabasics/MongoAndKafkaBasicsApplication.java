package com.example.mongoandkafkabasics;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@ComponentScan({"com.example.mongoandkafkabasics.*"})
//@EnableJpaRepositories("java.repository")
@EntityScan("com.example.mongoandkafkabasics.db")
@SpringBootApplication
public class MongoAndKafkaBasicsApplication {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Fortaleza"));
    }
    public static void main(String[] args) {
        SpringApplication.run(MongoAndKafkaBasicsApplication.class, args);
    }

}
