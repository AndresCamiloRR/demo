package com.co.eventos.icesi.demo.postgresql.controller;

import com.co.eventos.icesi.demo.postgresql.DTO.ProgramDTO;
import com.co.eventos.icesi.demo.postgresql.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("programs")
public class ProgramRestController {

    @Autowired
    ProgramService service;

    @GetMapping("/all")
    ResponseEntity<List<ProgramDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }


}
