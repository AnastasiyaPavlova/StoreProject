package com.example.storeproject.dto.productDto.request;


public class ProductUpdateCountRequestDto {
    private Long id;
    private int count;

    public ProductUpdateCountRequestDto(Long id, int count) {
        this.id = id;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}













