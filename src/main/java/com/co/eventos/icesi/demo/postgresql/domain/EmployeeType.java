package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tipos_empleado")
public class EmployeeType {
    @Id
    @Column(name = "nombre")
    private String name;

}
