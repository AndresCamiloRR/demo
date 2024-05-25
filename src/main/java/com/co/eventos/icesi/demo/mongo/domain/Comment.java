package com.co.eventos.icesi.demo.mongo.domain;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "comments")
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private String id;

    private String eventName;

    private String text;

    private String author;
}
