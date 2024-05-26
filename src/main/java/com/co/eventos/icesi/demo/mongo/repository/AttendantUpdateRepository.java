package com.co.eventos.icesi.demo.mongo.repository;

import com.co.eventos.icesi.demo.mongo.domain.Attendant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttendantUpdateRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addEventsToAttendant(String username, List<String> eventIds) {
        mongoTemplate.updateFirst(
                Query.query(Criteria.where("username").is(username)),
                new Update().addToSet("events").each(eventIds.toArray()),
                Attendant.class
        );
    }
}

