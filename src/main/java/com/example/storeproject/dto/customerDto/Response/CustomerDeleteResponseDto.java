package com.example.storeproject.dto.customerDto.Response;

import com.example.storeproject.entity.Customer;

public class CustomerDeleteResponseDto {
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDeleteResponseDto(Customer customer) {
        this.id = customer.getId();
            }
}
