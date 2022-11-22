package com.example.storeproject.dto.customerDto.Response;

import com.example.storeproject.dto.customerDto.Request.CustomerCreateRequestDto;
import com.example.storeproject.entity.Customer;

import java.util.Objects;

public class CustomerEditNameResponseDto {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerEditNameResponseDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerCreateRequestDto)) return false;
        CustomerCreateRequestDto that = (CustomerCreateRequestDto) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}

