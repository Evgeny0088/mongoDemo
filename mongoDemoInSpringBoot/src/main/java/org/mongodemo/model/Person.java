package org.mongodemo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "person")
public class Person {
    @MongoId
    String id;
    String firstName;
    String secondName;
    @Indexed(unique = true)
    String email;
    Gender gender;
    Address address;
    List<String> favourSubject;
    BigDecimal totalSpendInBooks;
    LocalDateTime dateTime;

    public Person(String firstName,
                  String secondName,
                  String email,
                  Gender gender,
                  Address address,
                  List<String> favourSubject,
                  BigDecimal totalSpendInBooks,
                  LocalDateTime dateTime) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favourSubject = favourSubject;
        this.totalSpendInBooks = totalSpendInBooks;
        this.dateTime = dateTime;
    }
}
