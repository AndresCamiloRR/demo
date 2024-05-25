package com.co.eventos.icesi.demo.postgresql.mapper;

import com.co.eventos.icesi.demo.postgresql.DTO.ProgramDTO;
import com.co.eventos.icesi.demo.postgresql.domain.Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProgramMapper {

    @Mapping(source = "area.code", target = "area")
    ProgramDTO toDto(Program program);

    @Mapping(source = "code", target = "area.code")
    Program toEntity(ProgramDTO programDTO);

    @Mapping(source = "area.code", target = "area")
    List<ProgramDTO> toDto(List<Program> programs);

    @Mapping(source = "code", target = "area.code")
    List<Program> toEntity(List<ProgramDTO> programDTOs);

}
