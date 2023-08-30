package org.example;

import javax.persistence.*;

@Entity
@Table(name = "Suppliers")
public class Supplier extends Company {
    private String backAccountNumber;

    public Supplier() {}

    public Supplier(String companyName, String street, String city, String zipCode, String backAccountNumber) {
        super(companyName, street, city, zipCode);
        this.backAccountNumber = backAccountNumber;
    }
}
