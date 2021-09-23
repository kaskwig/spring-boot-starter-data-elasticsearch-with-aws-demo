package io.monster.ocs.cm.customer.repository;

import io.monster.ocs.cm.customer.CustomerDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<CustomerDocument, String> {

    CustomerDocument findByEmailAddress(String emailAddress);

    @Query("{\"match\": {\"?0\": \"?1\"}}")
    List<CustomerDocument> findByUsingQuery(String key, String value);

    @Query("{\"bool\": {\"must\": [ {\"match\": {\"firstName\": \"?0\"}}, {\"match\": {\"userId\": 137680508}} ]}}")
    Optional<CustomerDocument> getByFirstName(String firstName);
}
