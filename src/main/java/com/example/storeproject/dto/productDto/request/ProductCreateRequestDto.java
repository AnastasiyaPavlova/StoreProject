package com.example.storeproject.dto.productDto.request;


public class ProductCreateRequestDto {

    private Long categoryId;
    private String name;
    private boolean visible;
    private double price;
    private int count;


    public ProductCreateRequestDto(Long categoryId, String name, boolean visible, double price, int count) {
        this.categoryId = categoryId;
        this.name = name;
        this.visible = visible;
        this.price = price;
        this.count = count;
    }

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



