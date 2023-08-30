package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryID;
    private String name;
    @OneToMany
    @JoinColumn(name = "categoryID")
    private List<Product> products = new ArrayList<>();

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public void addProducts(List<Product> productList) {
        this.products.addAll(productList);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String toString() {
        return this.name;
    }
}
