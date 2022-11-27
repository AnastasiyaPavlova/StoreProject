package com.example.storeproject.exeption;

public class OrderProductNotEnoughProductException extends RuntimeException {
    public OrderProductNotEnoughProductException(String message) {
        super(message);
    }
}