package com.co.eventos.icesi.demo.mongo.domain;

import com.co.eventos.icesi.demo.postgresql.DTO.ProgramDTO;
import com.co.eventos.icesi.demo.postgresql.domain.Faculty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "events")
@NoArgsConstructor
public class Event {

    @Id
    private String title;

    private String description;

    private String[] categories;

    private Date date;

    private Location location;

    private Faculty[] faculties;

    private ProgramDTO[] programs;

    private String[] attendants;

}
