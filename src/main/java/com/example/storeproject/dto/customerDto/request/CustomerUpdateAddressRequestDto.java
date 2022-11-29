package com.example.storeproject.dto.customerDto.request;


import java.util.Objects;

public class CustomerUpdateAddressRequestDto {
    private Long id;
    private String address;

    public CustomerUpdateAddressRequestDto(Long id, String address) {
        this.id = id;
        this.address = address;
    }
    public CustomerUpdateAddressRequestDto(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof CustomerUpdateAddressRequestDto that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress());
    }
}
