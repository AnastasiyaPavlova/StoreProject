package com.example.storeproject.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "gen_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private Long customerId;

    private Long deliveryId;

    private String address;

    private Long orderStatusId;

    private double cost;

 private LocalDate date;


    public Order(Long customerId, Long deliveryId, Long orderStatusId, LocalDate date, double cost, String address) {
        this.customerId = customerId;
        this.deliveryId = deliveryId;
        this.orderStatusId = orderStatusId;
        this.date=date;
        this.cost = cost;
        this.address = address;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Double.compare(order.getCost(), getCost()) == 0 && Objects.equals(getId(), order.getId()) && Objects.equals(getCustomerId(), order.getCustomerId()) && Objects.equals(getDeliveryId(), order.getDeliveryId()) && Objects.equals(getAddress(), order.getAddress()) && Objects.equals(getOrderStatusId(), order.getOrderStatusId()) && Objects.equals(getDate(), order.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getDeliveryId(), getAddress(), getOrderStatusId(), getCost(), getDate());
    }
}

