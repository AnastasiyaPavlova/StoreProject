package com.example.storeproject.dto.productDto.request;


import java.util.Objects;

public class ProductUpdateVisibleRequestDto {
    private Long id;
    private boolean visible;

    public ProductUpdateVisibleRequestDto(Long id, boolean visible) {
        this.id = id;
        this.visible = visible;
    }
    public ProductUpdateVisibleRequestDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductUpdateVisibleRequestDto that)) return false;
        return isVisible() == that.isVisible() && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isVisible());
    }
}













