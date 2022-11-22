package com.example.storeproject.dto.customerDto.Request;

import com.example.storeproject.dto.customerDto.Request.CustomerCreateRequestDto;

import java.util.Objects;

public class CustomerDeleteRequestDto {

    private Long id;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public CustomerDeleteRequestDto(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerCreateRequestDto)) return false;
        CustomerCreateRequestDto that = (CustomerCreateRequestDto) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
