package com.co.eventos.icesi.demo.postgresql.mapper;

import com.co.eventos.icesi.demo.postgresql.DTO.EmployeeDTO;
import com.co.eventos.icesi.demo.postgresql.domain.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {CityMapper.class})
public interface EmployeeMapper {

    @Mapping(source = "faculty.name", target = "faculty")
    @Mapping(source = "placeOfBirth", target = "placeOfBirth")
    @Mapping(source = "headQuarter.name", target = "headQuarter")
    @Mapping(source = "contractType.name", target = "contractType")
    @Mapping(source = "employeeTypeEntity.name", target = "employeeTypeEntity")
    EmployeeDTO toDTO(Employee employee);

}
