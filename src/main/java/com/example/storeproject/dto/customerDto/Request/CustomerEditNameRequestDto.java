package com.example.storeproject.dto.customerDto.Request;


public class CustomerEditNameRequestDto {

    private Long id;
    private String name;

    public CustomerEditNameRequestDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}