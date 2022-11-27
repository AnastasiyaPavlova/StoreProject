package com.example.storeproject.dto.categoryDto.request;

public class CategoryCreateRequestDto {
    private String name;
    private long parentCategoryId;

    public CategoryCreateRequestDto(String name, long parentCategoryId) {
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}




