package com.example.storeproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id")
    private Long id;
    private Long deliveryId;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderStatus that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDeliveryId(), that.getDeliveryId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeliveryId(), getName());
    }

    public OrderStatus(String name, Long deliveryId) {

        this.name = name;
        this.deliveryId=deliveryId;
    }
    public OrderStatus() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}


