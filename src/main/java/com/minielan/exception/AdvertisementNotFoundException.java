package com.minielan.exception;

public class AdvertisementNotFoundException extends RuntimeException {
    public AdvertisementNotFoundException(Long id) {
        super(String.format("Category not found with id: %d", id));
    }

    public AdvertisementNotFoundException(String message) {
        super(message);
    }
}
