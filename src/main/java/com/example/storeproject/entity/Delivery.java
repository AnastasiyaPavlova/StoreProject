package com.example.storeproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;
    private String name;

    public Delivery(String name) {
        this.name = name;
    }
    public Delivery() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

       public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery delivery)) return false;
        return Objects.equals(getId(), delivery.getId()) && Objects.equals(getName(), delivery.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}


