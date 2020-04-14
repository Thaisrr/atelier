package fr.dawan.atelier.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product extends BaseEntity implements Serializable {

    @Column(nullable = false, unique = true, length = 150)
    private String description;

    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Product() { }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
