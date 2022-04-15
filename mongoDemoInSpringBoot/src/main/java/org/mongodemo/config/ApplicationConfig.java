package org.mongodemo.config;

import lombok.extern.slf4j.Slf4j;
import org.mongodemo.model.Address;
import org.mongodemo.model.Gender;
import org.mongodemo.model.Person;
import org.mongodemo.repository.PersonRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Configuration
@Slf4j
public class ApplicationConfig {

    @Bean
    CommandLineRunner runner(PersonRepo personRepo, MongoTemplate template){
        return args -> {
            Person person = new Person("maria", "kuznetsova", String.format("%s@gmail.com", UUID.randomUUID()),
                    Gender.MALE, new Address("rus", "mos", 1000),
                    List.of("market"), BigDecimal.TEN, LocalDateTime.now());
            Person person1 = new Person("evgeny", "kuznetsov", String.format("%s@gmail.com", UUID.randomUUID()),
                    Gender.MALE, new Address("rus", "mos", 1000),
                    List.of("market"), BigDecimal.TEN, LocalDateTime.now());
            List<Person> persons = personRepo.findByFirstName("maria");
            if (!persons.isEmpty()){
                log.error("already exists");
            }else {
                personRepo.insert(person);
                personRepo.insert(person1);
            }
        };
    }

    private void queryAndSave(PersonRepo personRepo, MongoTemplate template, Person person) {
        Query query = new Query(Criteria.where("email").is(person.getEmail()));
        List<Person> personList = template.find(query, Person.class);
        if (personList.size()>1){
            throw new RuntimeException();
        }else{
            personRepo.insert(person);
        }
    }
}
