package com.example.storeproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Customer(Long id,String name, String address) {
        this.id=id;
        this.name = name;
        this.address = address;
    }

    public Customer() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getAddress(), customer.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress());
    }
}