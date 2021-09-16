package com.demo.aws.elasticsearch.data.repository;

import com.demo.aws.elasticsearch.data.document.PhotoDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhotoRepository extends ElasticsearchRepository<PhotoDocument, String> {

//    Page<PhotoDocument> findByTitle(String title, Pageable pageable);
//
//    Page<PhotoDocument> findByUrl(String title, Pageable pageable);
//
//    Page<PhotoDocument> findByThumbnailUrl(String title, Pageable pageable);
   // @Query("{\"bool\": {\"must\": [ {\"match\": {\"Firstname\": \"?0\"}}, {\"match\": {\"UserID\": 127592423}} ]}}")
//    @Query("{\"match\": {\"UserID\": \"127592423\"}}")
    Optional<PhotoDocument> findByEmailAddress(String id);

    @Query("{\"match\": {\"?0\": \"?1\"}}")
    List<PhotoDocument> findByUsingQuery(String key, String value);
}
