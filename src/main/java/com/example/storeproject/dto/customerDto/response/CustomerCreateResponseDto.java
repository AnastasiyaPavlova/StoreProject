package com.example.storeproject.dto.customerDto.response;

import com.example.storeproject.entity.Customer;

public class CustomerCreateResponseDto {
    private String name;
    private String address;

    public CustomerCreateResponseDto(Customer customer) {
        this.name = customer.getName();
        this.address = customer.getAddress();
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
}



