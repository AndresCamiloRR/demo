package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer code;

    @Column(name = "nombre")
    private String name;

    @Column(name = "codigo_facultad")
    private Integer facultyCode;

    @Column(name = "id_coordinador")
    private String coordinatorId;

}
