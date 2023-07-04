package com.example.mongoandkafkabasics.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "post")
public class Post implements Serializable {
    @Id
    private String id;
    private String title;
    private String body;
    private Date data;
    private User author;

}
