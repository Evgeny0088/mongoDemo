package org.mongodemo.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import lombok.extern.slf4j.Slf4j;
import org.mongodemo.model.Address;
import org.mongodemo.model.Gender;
import org.mongodemo.model.Person;
import org.mongodemo.repository.PersonRepo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ChangeLog
@Slf4j
public class Mogrations {

    @ChangeSet(order="001", id= "001", author = "evgeny88")
    public void personMigration1(PersonRepo personRepo){
        List<Person> persons = List.of(
                new Person("maria", "kuznetsova", String.format("%s@gmail.com", UUID.randomUUID()),
                        Gender.FEMALE, new Address("rus", "mos", 1000),
                        List.of("market"), BigDecimal.TEN, LocalDateTime.now()),
                new Person("evgeny", "kuznetsov", String.format("%s@gmail.com", UUID.randomUUID()),
                        Gender.MALE, new Address("rus", "mos", 1000),
                        List.of("sport"), BigDecimal.TEN, LocalDateTime.now()),
                new Person("egor", "kuznetsov", String.format("%s@gmail.com", UUID.randomUUID()),
                        Gender.MALE, new Address("rus", "mos", 1000),
                        List.of("cinema"), BigDecimal.TEN, LocalDateTime.now()),
                new Person("philipp", "kuznetsov", String.format("%s@gmail.com", UUID.randomUUID()),
                        Gender.MALE, new Address("rus", "mos", 1000),
                        List.of("toys"), BigDecimal.TEN, LocalDateTime.now())
        );
        personRepo.insert(persons);
        log.info("persons are created>>>>");
    }
}