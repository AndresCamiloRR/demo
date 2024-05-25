package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sedes")
public class HeadQuarter {
    @Id
    @Column(name = "codigo")
    private Integer code;

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "cod_ciudad", referencedColumnName = "codigo")
    private City city;

}
