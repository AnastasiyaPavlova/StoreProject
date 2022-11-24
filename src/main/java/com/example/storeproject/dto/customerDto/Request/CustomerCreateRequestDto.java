package com.example.storeproject.dto.customerDto.Request;


public class CustomerCreateRequestDto {
    private Long id;
    private String name;
    private String address;

    public CustomerCreateRequestDto(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
