package com.co.eventos.icesi.demo.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "attendants")
@NoArgsConstructor
public class Attendant {

    @Id
    private String username;

    private String name;

    private String relation;

    private String email;

    private City city;

    private String[] events;


}
