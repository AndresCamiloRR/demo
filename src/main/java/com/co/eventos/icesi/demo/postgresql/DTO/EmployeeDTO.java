package com.co.eventos.icesi.demo.postgresql.DTO;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String faculty;

    private CityDTO placeOfBirth;

    private String headQuarter;

    private String contractType;

    private String employeeTypeEntity;
}
