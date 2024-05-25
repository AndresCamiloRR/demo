package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empleados")
public class Employee {
    @Id
    @Column(name = "identificacion")
    private String id;

    @Column(name = "nombres")
    private String firstName;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "cod_facultad")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "lugar_nacimiento", referencedColumnName = "codigo")
    private City placeOfBirth;

    @ManyToOne
    @JoinColumn(name = "codigo_sede")
    private HeadQuarter headQuarter;

    @ManyToOne
    @JoinColumn(name = "tipo_contratacion")
    private EmploymentType contractType;

    @ManyToOne
    @JoinColumn(name = "tipo_empleado")
    private EmployeeType employeeTypeEntity;

}

