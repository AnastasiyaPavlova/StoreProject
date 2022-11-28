package com.example.storeproject.dto.productDto.request;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductUpdateCountRequestDto that)) return false;
        return getCount() == that.getCount() && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCount());
    }
}













