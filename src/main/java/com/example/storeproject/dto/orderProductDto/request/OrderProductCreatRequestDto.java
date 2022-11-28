package com.example.storeproject.dto.orderProductDto.request;


import java.util.Objects;

public class OrderProductCreatRequestDto {

    private Long productId;
    private int count;


    public OrderProductCreatRequestDto(Long productId, int count) {
        this.productId = productId;
        this.count = count;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
        if (!(o instanceof OrderProductCreatRequestDto that)) return false;
        return getCount() == that.getCount() && Objects.equals(getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getCount());
    }
}



