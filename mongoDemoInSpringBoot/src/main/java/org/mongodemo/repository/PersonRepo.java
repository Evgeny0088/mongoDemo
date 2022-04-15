package org.mongodemo.repository;

import org.mongodemo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepo extends MongoRepository<Person, String> {
    List<Person> findByFirstName(String firstName);

    Optional<Person> findByFirstNameAndEmail(String firstName, String email);

    @Query("{firstName:{$ne:?0}}")
    List<Person>findPersonNotEqualsToSpecificName(String name);
}
