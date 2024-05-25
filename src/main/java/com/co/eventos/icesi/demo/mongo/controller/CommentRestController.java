package com.co.eventos.icesi.demo.mongo.controller;

import com.co.eventos.icesi.demo.mongo.domain.Comment;
import com.co.eventos.icesi.demo.mongo.repository.CommentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("comments")
public class CommentRestController {

    @Autowired
    CommentRepository repository;

    @PostMapping(path = "/add")
    public ResponseEntity<Comment> saveComment(
            @RequestBody Comment comment
            ) {
        return ResponseEntity.ok(repository.save(comment));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Comment>> searchComments(
            @RequestParam String author,
            @RequestParam String eventName,
            @RequestParam String text) {
        return ResponseEntity.ok(repository.findByAuthorContainingAndEventNameContainingAndTextContaining(author, eventName, text));
    }

    @DeleteMapping("/deleteByComment")
    public void deleteCommentByComment(@RequestBody Comment comment) {
        System.out.println(comment);
        repository.delete(comment);
    }



}
