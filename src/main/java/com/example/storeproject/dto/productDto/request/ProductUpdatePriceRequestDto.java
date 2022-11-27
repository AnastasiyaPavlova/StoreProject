package com.example.storeproject.dto.productDto.request;


public class ProductUpdatePriceRequestDto {
    private Long id;
    private double price;

    public ProductUpdatePriceRequestDto(Long id, double price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}













