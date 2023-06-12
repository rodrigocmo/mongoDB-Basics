package com.example.mongoandkafkabasics.db;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    String name;
    String email;

}
