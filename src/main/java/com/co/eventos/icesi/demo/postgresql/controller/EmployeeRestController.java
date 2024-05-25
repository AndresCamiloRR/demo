package com.co.eventos.icesi.demo.postgresql.controller;

import com.co.eventos.icesi.demo.postgresql.DTO.EmployeeDTO;
import com.co.eventos.icesi.demo.postgresql.domain.Employee;
import com.co.eventos.icesi.demo.postgresql.mapper.EmployeeMapper;
import com.co.eventos.icesi.demo.postgresql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("employees")
public class EmployeeRestController {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    EmployeeMapper mapper;

    @GetMapping("/findById")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@RequestParam String id) {
        return ResponseEntity.ok(mapper.toDTO(repository.findById(id)));
    }

}
