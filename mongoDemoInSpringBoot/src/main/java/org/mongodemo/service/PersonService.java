package org.mongodemo.service;

import org.mongodemo.model.Person;
import org.mongodemo.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> fetchAllPersons() {
        List<Person> personList = personRepo.findAll();
        return !personList.isEmpty() ? personList : Collections.emptyList();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = true)
    public List<Person> fetchAllPersonsExceptSpecificName(String name) {
        if (name != null){
            List<Person> persons = personRepo.findPersonNotEqualsToSpecificName(name);
            return !persons.isEmpty() ? persons : Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void createPerson(Person person) {
        person.setCreatedOn(LocalDateTime.now());
        personRepo.save(person);
    }
}
