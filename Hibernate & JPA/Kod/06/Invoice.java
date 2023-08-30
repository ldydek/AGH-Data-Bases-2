package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceNumber;
    private int quantity = 0;

    @ManyToMany(mappedBy = "invoices")
    private List<Product> products;

    public Invoice() {}

    public void addProduct(Product product, int quantity) {
        this.products.add(product);
        this.quantity += quantity;
    }
}
