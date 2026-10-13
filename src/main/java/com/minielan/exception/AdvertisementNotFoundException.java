package com.minielan.exception;

public class AdvertisementNotFoundException extends RuntimeException {
    public AdvertisementNotFoundException(Long id) {
        super(String.format("Advertisement not found with id: %d", id));
    }
}
