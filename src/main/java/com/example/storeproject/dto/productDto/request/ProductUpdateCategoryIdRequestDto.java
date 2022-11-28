package com.example.storeproject.dto.productDto.request;


import java.util.Objects;

public class ProductUpdateCategoryIdRequestDto {
    private Long id;
    private Long categoryId;

    public ProductUpdateCategoryIdRequestDto(Long id, Long categoryId) {
        this.id = id;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductUpdateCategoryIdRequestDto that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCategoryId(), that.getCategoryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategoryId());
    }
}











