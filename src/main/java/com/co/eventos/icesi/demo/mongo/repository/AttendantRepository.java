package com.co.eventos.icesi.demo.mongo.repository;

import com.co.eventos.icesi.demo.mongo.domain.Attendant;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendantRepository extends MongoRepository<Attendant, String> {

    @Aggregation(pipeline = {
            "{$group: {_id: '$relation' } }",
            "{$project: {relation: '$_id', '_id': 0 } }",
            "{$sort: {relation: 1}}"
    })
    List<String> findDistinctRelations();

    @Query("{ $and: [ { 'username': { $regex: ?0, $options: 'i' } }, { 'name': { $regex: ?1, $options: 'i' } } ] }")
    List<Attendant> findByUsernameContainingAndNameContaining(String username, String name);

    @Query("{ $and: [ { $or: [ { 'userName': { $regex: ?0, $options: 'i' } }, { 'name': { $regex: ?1, $options: 'i' } } ] }, { 'relation': { $in: ?2 } } ] }")
    List<Attendant> findByUserNameOrNameContainingAndRelationIn(String userNamePattern, String namePattern, List<String> relations);

    void deleteByUsername(String username);

}
