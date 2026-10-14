package com.minielan.exception;

public class CategoryNotFoundException  extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super(String.format("Category not found with id: %d", id));
    }
}