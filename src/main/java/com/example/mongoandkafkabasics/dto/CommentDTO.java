package com.example.mongoandkafkabasics.dto;

import com.example.mongoandkafkabasics.db.User;

import java.time.LocalDate;

public class CommentDTO {

    private String text;
    private LocalDate data;
    private User author;
}
