package com.example.storeproject.dto.orderDto.response;


import com.example.storeproject.dto.orderProductDto.response.OrderProductGetByOrderIdResponseDto;
import com.example.storeproject.entity.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderGetByOrderIdResponseDto {
    private Long customerId;
    private String address;
    private Long deliveryId;
    private Long orderStatusId;
    private double cost;
    private LocalDate date;
    private List<OrderProductGetByOrderIdResponseDto> orderProductResponse;

    public OrderGetByOrderIdResponseDto(Order order, List<OrderProductGetByOrderIdResponseDto> orderProductResponseArray) {
        this.customerId = order.getCustomerId();
        this.address = order.getAddress();
        this.deliveryId = order.getDeliveryId();
        this.orderStatusId = order.getOrderStatusId();
        this.cost = order.getCost();
        this.date = order.getDate();
        List<OrderProductGetByOrderIdResponseDto> orderProductResponse = new ArrayList<>();
        this.orderProductResponse = orderProductResponseArray;
    }

    public OrderGetByOrderIdResponseDto() {
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

    public List<OrderProductGetByOrderIdResponseDto> getOrderProductResponse() {
        return orderProductResponse;
    }

    public void setOrderProductResponse(List<OrderProductGetByOrderIdResponseDto> orderProductResponse) {
        this.orderProductResponse = orderProductResponse;
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
        if (!(o instanceof OrderGetByOrderIdResponseDto)) return false;
        OrderGetByOrderIdResponseDto that = (OrderGetByOrderIdResponseDto) o;
        return
                Objects.equals(getCustomerId(), that.getCustomerId()) &&
                        Objects.equals(getAddress(), that.getAddress()) &&
                        Objects.equals(getDeliveryId(), that.getDeliveryId()) &&
                        Objects.equals(getOrderStatusId(), that.getOrderStatusId()) &&
                        Objects.equals(getCost(), that.getCost()) &&
                        Objects.equals(getDate(), that.getDate()) &&
                        Objects.equals(getOrderProductResponse(), that.getOrderProductResponse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getAddress(), getDeliveryId(), getOrderStatusId(), getCost(), getDate(), getOrderProductResponse());
    }


}
