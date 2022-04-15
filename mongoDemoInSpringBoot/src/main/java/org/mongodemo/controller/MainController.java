package org.mongodemo.controller;

import org.mongodemo.model.Person;
import org.mongodemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> fetchAllPersons(){
        return personService.fetchAllPersons();
    }

    @GetMapping("/except")
    public List<Person> findAllPersonsExceptSpecificName(@RequestParam(value = "name", required = false) String name){
        return personService.fetchAllPersonsExceptSpecificName(name);
    }
}
