package org.mongodemo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    int postcode;
}
