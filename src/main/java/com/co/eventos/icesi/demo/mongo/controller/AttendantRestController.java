package com.co.eventos.icesi.demo.mongo.controller;

import com.co.eventos.icesi.demo.mongo.domain.Attendant;
import com.co.eventos.icesi.demo.mongo.repository.AttendantRepository;
import com.co.eventos.icesi.demo.mongo.repository.AttendantUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("attendants")
public class AttendantRestController {

    @Autowired
    AttendantRepository repository;

    @Autowired
    AttendantUpdateRepository repositoryUpdate;

    @PostMapping("/add")
    public ResponseEntity<Attendant> addAttendant(@RequestBody Attendant attendant) {
        return ResponseEntity.ok(repository.save(attendant));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Attendant>> searchAttendants(
            @RequestParam String userNamePattern,
            @RequestParam String namePattern,
            @RequestParam String[] relations
    ) {
        return ResponseEntity.ok(repository.findByUserNameOrNameContainingAndRelationIn(userNamePattern, namePattern, List.of(relations)));
    }

    @GetMapping("/searchNoRelations")
    public ResponseEntity<List<Attendant>> searchAttendantsNoRelations(
            @RequestParam String userNamePattern,
            @RequestParam String namePattern
    ) {
        return ResponseEntity.ok(repository.findByUsernameContainingAndNameContaining(userNamePattern, namePattern));
    }

    @GetMapping("/relations")
    public ResponseEntity<List<String>> getRelations() {
        return ResponseEntity.ok(repository.findDistinctRelations());
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam String attendantId) {
        repository.deleteByUsername(attendantId);
    }

    @PutMapping("/addEvents")
    public void addEvents(
            @RequestParam String attendantId,
            @RequestParam List<String> categories
    ) {
        repositoryUpdate.addEventsToAttendant(attendantId, categories);
    }

    @GetMapping("/findByUsername")
    public ResponseEntity<Attendant> findByUsername(@RequestParam String username) {
        return ResponseEntity.ok(repository.findById(username).orElse(null));
    }

    @GetMapping("/findByName")
    public ResponseEntity<Attendant> findByName(@RequestParam String name) {
        return ResponseEntity.ok(repository.findByName(name).orElse(null));
    }

    @GetMapping("/findByUsernameList")
    public ResponseEntity<List<Attendant>> findByUsernameList(@RequestParam List<String> usernameList) {
        return ResponseEntity.ok(repository.findByUsernameIn(usernameList));
    }
}
