package com.example.storeproject.dto.customerDto.Response;

import com.example.storeproject.dto.customerDto.Request.CustomerCreateRequestDto;
import com.example.storeproject.entity.Customer;

import java.util.Objects;

public class CustomerCreateResponseDto {
    private Long id;
    private String name;
    private String address;

    public CustomerCreateResponseDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerCreateResponseDto)) return false;
        CustomerCreateResponseDto that = (CustomerCreateResponseDto) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress());
    }
}
