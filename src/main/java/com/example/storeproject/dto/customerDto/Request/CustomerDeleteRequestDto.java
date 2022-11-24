package com.example.storeproject.dto.customerDto.Request;


public class CustomerDeleteRequestDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDeleteRequestDto(Long id) {
        this.id = id;
    }
}
