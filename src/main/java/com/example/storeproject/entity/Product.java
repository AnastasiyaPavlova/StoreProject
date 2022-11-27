package com.example.storeproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private Long categoryId;
    private String name;
    private boolean visible;
    private double price;
    private int count;


    public Product(Long categoryId, String name, boolean visible, double price, int count) {
        this.categoryId = categoryId;
        this.name = name;
        this.visible = visible;
        this.price = price;
        this.count = count;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getVisible() == product.getVisible() && Double.compare(product.getPrice(), getPrice()) == 0 && getCount() == product.getCount() && Objects.equals(getId(), product.getId()) && Objects.equals(getCategoryId(), product.getCategoryId()) && Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategoryId(), getName(), getVisible(), getPrice(), getCount());
    }
}


