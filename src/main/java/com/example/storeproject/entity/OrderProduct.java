package com.example.storeproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private Long id;
    private Long orderId;
    private Long productId;
    private int count;
    private double price;
    private double cost;



    public OrderProduct(Long orderId,Long productId,int count,double price,double cost) {
        this.orderId = orderId;
        this.productId = productId;
        this.count = count;
        this.price = price;
        this.cost = cost;
    }

    public OrderProduct() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProduct that)) return false;
        return getCount() == that.getCount() && Double.compare(that.getPrice(), getPrice()) == 0 && Double.compare(that.getCost(), getCost()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getOrderId(), that.getOrderId()) && Objects.equals(getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderId(), getProductId(), getCount(), getPrice(), getCost());
    }
}