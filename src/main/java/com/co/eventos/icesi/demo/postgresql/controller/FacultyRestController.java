package com.co.eventos.icesi.demo.postgresql.controller;

import com.co.eventos.icesi.demo.postgresql.domain.Faculty;
import com.co.eventos.icesi.demo.postgresql.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("faculties")
public class FacultyRestController {

    @Autowired
    private FacultyRepository repository;



    @GetMapping("/all")
    public ResponseEntity<List<Faculty>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
