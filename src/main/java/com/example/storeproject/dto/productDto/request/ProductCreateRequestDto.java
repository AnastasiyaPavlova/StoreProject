package com.example.storeproject.dto.productDto.request;


import java.util.Objects;

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

    public ProductCreateRequestDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCreateRequestDto that)) return false;
        return isVisible() == that.isVisible() && Double.compare(that.getPrice(), getPrice()) == 0 && getCount() == that.getCount() && Objects.equals(getCategoryId(), that.getCategoryId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getName(), isVisible(), getPrice(), getCount());
    }
}



