package com.example.storeproject.dto.customerDto.request;

import java.util.Objects;

public class CustomerCreateRequestDto {
    private String name;
    private String address;

    public CustomerCreateRequestDto(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public CustomerCreateRequestDto(){}

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
        if (!(o instanceof CustomerCreateRequestDto that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getAddress(), that.getAddress());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress());
    }
}
