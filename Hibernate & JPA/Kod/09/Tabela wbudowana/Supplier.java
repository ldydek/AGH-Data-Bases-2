package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierID;
    private String companyName;
    @Embedded
    private Address address;

    @OneToMany
    @JoinColumn(name="supplierID")
    private final List<Product> products = new ArrayList<>();

    public Supplier() {}

    public Supplier(String companyName, Address address) {
        this.companyName = companyName;
        this.address = address;
    }
}
