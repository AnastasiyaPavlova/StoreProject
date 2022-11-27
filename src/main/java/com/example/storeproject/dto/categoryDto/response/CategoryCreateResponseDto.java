package com.example.storeproject.dto.categoryDto.response;


import com.example.storeproject.entity.Category;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryCreateResponseDto)) return false;
        CategoryCreateResponseDto that = (CategoryCreateResponseDto) o;
        return
                Objects.equals(getName(), that.getName()) &&
                getParentCategoryId() == that.getParentCategoryId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getParentCategoryId());
    }
}
