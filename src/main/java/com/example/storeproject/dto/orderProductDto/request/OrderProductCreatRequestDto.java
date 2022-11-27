package com.example.storeproject.dto.orderProductDto.request;


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
}



