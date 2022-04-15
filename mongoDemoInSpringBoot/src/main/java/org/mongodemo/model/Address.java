package org.mongodemo.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    int postcode;
}
