package org.example;

import javax.management.InvalidAttributeValueException;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private String productName;
    private int unitsOnStock;

    @ManyToOne
    @JoinColumn(name = "supplierID")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    @ManyToMany
    @JoinTable(name = "invoice_details")
    private List<Invoice> invoices;

    public Product() {}

    public Product(String productName, int unitsOnStock) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void sell(Invoice invoice, int quantity) throws Exception {
        if (this.unitsOnStock < quantity) {
            throw new Exception("Cannot sell " + quantity + " products.");
        }
        this.unitsOnStock -= quantity;
        invoice.addProduct(this, quantity);
        invoices.add(invoice);
    }

    public String toString() {
        return this.productName + " (" + unitsOnStock + " szt.)";
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

