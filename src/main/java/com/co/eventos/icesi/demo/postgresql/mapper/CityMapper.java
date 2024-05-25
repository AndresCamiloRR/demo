package com.co.eventos.icesi.demo.postgresql.mapper;

import com.co.eventos.icesi.demo.postgresql.DTO.CityDTO;
import com.co.eventos.icesi.demo.postgresql.domain.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CityMapper {

    @Mapping(source = "department.name", target = "department")
    @Mapping(source = "department.country.name", target = "country")
    CityDTO toDTO(City city);

}
