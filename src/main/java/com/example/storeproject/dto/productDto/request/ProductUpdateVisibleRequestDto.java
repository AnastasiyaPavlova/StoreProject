package com.example.storeproject.dto.productDto.request;


public class ProductUpdateVisibleRequestDto {
    private Long id;
    private boolean visible;

    public ProductUpdateVisibleRequestDto(Long id, boolean visible) {
        this.id = id;
        this.visible = visible;
    }


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
}













