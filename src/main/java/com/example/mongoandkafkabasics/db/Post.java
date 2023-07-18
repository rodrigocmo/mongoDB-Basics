package com.example.mongoandkafkabasics.db;

import com.example.mongoandkafkabasics.dto.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<CommentDTO> comments = new ArrayList<>();

}
