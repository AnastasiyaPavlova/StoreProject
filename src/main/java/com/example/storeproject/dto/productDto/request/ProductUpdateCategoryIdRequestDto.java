package com.example.storeproject.dto.productDto.request;


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
}











