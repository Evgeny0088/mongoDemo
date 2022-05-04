package org.mongodemo.migrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import lombok.extern.slf4j.Slf4j;
import org.mongodemo.model.Address;
import org.mongodemo.model.Gender;
import org.mongodemo.model.Person;
import org.mongodemo.repository.PersonRepo;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Configuration
@ChangeLog(order = "1")
@Slf4j
public class DataBaseChangeLock {

    @ChangeSet(order="001", id= "001", author = "evgeny88")
    public void firstChangeSet(PersonRepo personRepo){
        List<Person> persons = List.of(
                new Person("maria", "kuznetsova", String.format("%s@gmail.com", UUID.randomUUID()),
                        Gender.FEMALE, new Address("rus", "mos", 1000),
                        List.of("market"), BigDecimal.TEN),
                new Person("evgeny", "kuznetsov", String.format("%s@gmail.com", UUID.randomUUID()),
                        Gender.MALE, new Address("rus", "mos", 1000),
                        List.of("sport"), BigDecimal.TEN),
                new Person("egor", "kuznetsov", String.format("%s@gmail.com", UUID.randomUUID()),
                        Gender.MALE, new Address("rus", "mos", 1000),
                        List.of("cinema"), BigDecimal.TEN),
                new Person("philipp", "kuznetsov", String.format("%s@gmail.com", UUID.randomUUID()),
                        Gender.MALE, new Address("rus", "mos", 1000),
                        List.of("toys"), BigDecimal.TEN)
        );
        personRepo.saveAll(persons);
        log.info("persons are created>>>>");
    }
}
