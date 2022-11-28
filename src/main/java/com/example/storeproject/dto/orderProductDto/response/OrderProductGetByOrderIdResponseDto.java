package com.example.storeproject.dto.orderProductDto.response;


import com.example.storeproject.entity.OrderProduct;

import java.util.Objects;

public class OrderProductGetByOrderIdResponseDto {
    private Long productId;
    private int count;
    private double price;
       private double cost;


    public OrderProductGetByOrderIdResponseDto(OrderProduct orderProduct){
        this.productId= orderProduct.getProductId();
        this.count= orderProduct.getCount();
        this.price=orderProduct.getPrice();
        this.cost=orderProduct.getCost();
    }
    public OrderProductGetByOrderIdResponseDto(){}

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
}
