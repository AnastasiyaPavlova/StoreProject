package com.example.storeproject.dto.productDto.response;

import com.example.storeproject.entity.Product;

public class ProductCreateResponseDto {
    private Long categoryId;
    private String name;
    private boolean visible;
    private double price;
    private int count;

    public ProductCreateResponseDto(Product product) {
        this.categoryId = product.getCategoryId();
        this.name = product.getName();
        this.visible = product.getVisible();
        this.price = product.getPrice();
        this.count = product.getCount();
    }
    public ProductCreateResponseDto(){}
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

