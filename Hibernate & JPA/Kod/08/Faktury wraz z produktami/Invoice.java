package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceNumber;
    private int quantity = 0;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "invoices")
    private List<Product> products = new ArrayList<>();

    public Invoice() {}

    public void addProduct(Product product, int quantity) {
        this.products.add(product);
        this.quantity += quantity;
    }
}
