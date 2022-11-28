package com.example.storeproject.dto.orderDto.request;


import com.example.storeproject.dto.orderProductDto.request.OrderProductCreatRequestDto;

import java.util.*;

public class OrderCreatRequestDto {

    private Long customerId;
    private String address;
    private Long deliveryId;
     private List<OrderProductCreatRequestDto> orderProductRequestArray = new ArrayList<>();

    public OrderCreatRequestDto(Long customerId, String address, Long deliveryId, List<OrderProductCreatRequestDto> orderProductRequestArray){
        this.customerId=customerId;
        this.address=address;
        this.deliveryId=deliveryId;
        this.orderProductRequestArray=orderProductRequestArray;
    }
    public OrderCreatRequestDto(){}

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

    public List<OrderProductCreatRequestDto> orderProductRequestArray() {
        return orderProductRequestArray;
    }

    public void setOrderProductArray(List<OrderProductCreatRequestDto> orderProductRequestArray) {
        this.orderProductRequestArray = orderProductRequestArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderCreatRequestDto that)) return false;
        return Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getDeliveryId(), that.getDeliveryId()) && Objects.equals(orderProductRequestArray, that.orderProductRequestArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getAddress(), getDeliveryId(), orderProductRequestArray);
    }
}



