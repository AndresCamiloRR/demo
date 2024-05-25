package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tipos_contratacion")
public class EmploymentType {
    @Id
    @Column(name = "nombre")
    private String name;

    @OneToMany(mappedBy = "contractType")
    private List<Employee> employees;

}
