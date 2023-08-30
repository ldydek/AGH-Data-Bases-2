package org.example;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String street;

    public Address() {}

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
