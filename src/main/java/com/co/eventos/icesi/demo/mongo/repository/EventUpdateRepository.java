package com.co.eventos.icesi.demo.mongo.repository;

import com.co.eventos.icesi.demo.mongo.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventUpdateRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addAttendantsToList(String eventId, List<String> newAttendants) {
        mongoTemplate.updateFirst(
                Query.query(Criteria.where("title").is(eventId)),
                new Update().addToSet("attendants").each(newAttendants.toArray()),
                Event.class
        );
    }
}