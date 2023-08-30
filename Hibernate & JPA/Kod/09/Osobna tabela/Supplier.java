package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SecondaryTable(name="Addresses")
@Table(name = "Suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierID;
    private String companyName;
    @Column(table = "Addresses")
    private String city;
    @Column(table = "Addresses")
    private String street;

    @OneToMany
    @JoinColumn(name="supplierID")
    private final List<Product> products = new ArrayList<>();

    public Supplier() {}

    public Supplier(String companyName, String city, String street) {
        this.companyName = companyName;
        this.city = city;
        this.street = street;
    }
}
