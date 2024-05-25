package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "paises")
public class Country {
    @Id
    @Column(name = "codigo")
    private Integer code;

    @Column(name = "nombre")
    private String name;

}
