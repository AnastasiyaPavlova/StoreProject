package com.example.storeproject.dto.customerDto.Response;

import com.example.storeproject.entity.Customer;

public class CustomerCreatResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }







    public CustomerCreatResponseDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.address = customer.getPhone();
            }
}
