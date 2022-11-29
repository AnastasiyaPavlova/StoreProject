package com.example.storeproject.dto.productDto.request;


import java.util.Objects;

public class ProductUpdatePriceRequestDto {
    private Long id;
    private double price;

    public ProductUpdatePriceRequestDto(Long id, double price) {
        this.id = id;
        this.price = price;
    }
    public ProductUpdatePriceRequestDto(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductUpdatePriceRequestDto that)) return false;
        return Double.compare(that.getPrice(), getPrice()) == 0 && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice());
    }
}













