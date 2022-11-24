package com.example.storeproject.exeption;

public class ParentCategoryNotFoundException extends RuntimeException {
    public ParentCategoryNotFoundException(String message) {
        super(message);
    }
}