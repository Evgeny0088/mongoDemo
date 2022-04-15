package org.mongodemo.service;

import ch.qos.logback.core.joran.conditional.IfAction;
import org.mongodemo.model.Person;
import org.mongodemo.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Person> fetchAllPersonsExceptSpecificName(String name) {
        if (name != null){
            List<Person> persons = personRepo.findPersonNotEqualsToSpecificName(name);
            return !persons.isEmpty() ? persons : Collections.emptyList();
        }
        return Collections.emptyList();
    }
}
