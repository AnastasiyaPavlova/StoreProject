package com.example.storeproject.dto.categoryDto.request;

import java.util.Objects;

public class CategoryCreateRequestDto {
    private String name;

    private long parentCategoryId;

    public CategoryCreateRequestDto(String name, long parentCategoryId) {
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }

    public CategoryCreateRequestDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryCreateRequestDto that)) return false;
        return getParentCategoryId() == that.getParentCategoryId() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getParentCategoryId());
    }
}




