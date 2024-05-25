package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "departamentos")
public class Department {
    @Id
    @Column(name = "codigo")
    private Integer code;

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "cod_pais", referencedColumnName = "codigo")
    private Country country;

    @OneToMany(mappedBy = "department")
    private List<City> cities;

}

