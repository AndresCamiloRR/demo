package com.co.eventos.icesi.demo.mongo.repository;

import com.co.eventos.icesi.demo.mongo.domain.Event;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, Integer> {

    void deleteByTitle(String title);

    @Aggregation(pipeline = {
            "{$unwind: '$categories'}",
            "{$group: {_id: '$categories'}}",
            "{$project: {_id: 0, categories: '$_id'}}",
            "{$sort: {categories: 1}}" // Agregar ordenación ascendente por categorías
    })
    List<String> findDistinctCategories();

    @Query("{$and:[{'title': {$regex: ?0, $options: 'i'}}, {'location.name': {$regex: ?1, $options: 'i'}}]}")
    List<Event> findByTitleContainingAndLocationNameContainingIgnoreCase(
            String title,
            String locationName
    );

    @Query("{$and:[{'title': {$regex: ?0, $options: 'i'}}, {'location.name': {$regex: ?1, $options: 'i'}}, {'categories': {$in: ?2}}]}")
    List<Event> findByTitleContainingAndLocationNameContainingAndCategoriesContainingAllIgnoreCase(
            String title,
            String locationName,
            List<String> categories
    );
}
