package com.co.eventos.icesi.demo.postgresql;

import com.co.eventos.icesi.demo.postgresql.DTO.ProgramDTO;
import com.co.eventos.icesi.demo.postgresql.mapper.ProgramMapper;
import com.co.eventos.icesi.demo.postgresql.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    @Autowired
    ProgramRepository repository;

    @Autowired
    ProgramMapper mapper;

    public List<ProgramDTO> getAll(){
        return mapper.toDto(repository.findAll());
    }

}
