package com.co.eventos.icesi.demo.mongo.repository;

import com.co.eventos.icesi.demo.mongo.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Integer> {

    @Query("{ 'author': { $regex: ?0, $options: 'i' }, 'eventName': { $regex: ?1, $options: 'i' }, 'text': { $regex: ?2, $options: 'i' } }")
    List<Comment> findByAuthorContainingAndEventNameContainingAndTextContaining(String author, String eventName, String text);

}
