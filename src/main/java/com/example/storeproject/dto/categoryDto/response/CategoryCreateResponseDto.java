package com.example.storeproject.dto.categoryDto.response;

import com.example.storeproject.entity.Category;

public class CategoryCreateResponseDto {
    private String name;
    private long parentCategoryId;

    public CategoryCreateResponseDto(Category category) {
        this.name = category.getName();
        this.parentCategoryId = category.getParentCategoryId();
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
