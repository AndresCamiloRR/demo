package com.co.eventos.icesi.demo.mongo.controller;

import com.co.eventos.icesi.demo.mongo.domain.Event;
import com.co.eventos.icesi.demo.mongo.repository.EventRepository;
import com.co.eventos.icesi.demo.mongo.repository.EventUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("events")
public class EventRestController {

    @Autowired
    private EventRepository repository;

    @Autowired
    private EventUpdateRepository repositoryUpdate;

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        return ResponseEntity.ok(repository.save(event));
    }

    @DeleteMapping("/deleteByTitle")
    public void deleteEventByTitle(@RequestParam String eventTitle) {
        repository.deleteByTitle(eventTitle);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getCategories() {
        return ResponseEntity.ok(repository.findDistinctCategories());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEvents(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "categories", required = false) List<String> categories
    ) {
        return ResponseEntity.ok(repository.findByTitleContainingAndLocationNameContainingAndCategoriesContainingAllIgnoreCase(
                title != null ? title : "",
                location != null ? location : "",
                categories != null ? categories : List.of()
        ));
    }

    @GetMapping("/searchNoCategories")
    public ResponseEntity<List<Event>> searchEvents(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "location", required = false) String location
    ) {
        return ResponseEntity.ok(repository.findByTitleContainingAndLocationNameContainingIgnoreCase(
                title != null ? title : "",
                location != null ? location : ""
        ));
    }

    @PutMapping("/addAttendants")
    public void addAttendants(
            @RequestParam String title,
            @RequestParam List<String> attendants
    ) {
        repositoryUpdate.addAttendantsToList(title, attendants);
    }

}
