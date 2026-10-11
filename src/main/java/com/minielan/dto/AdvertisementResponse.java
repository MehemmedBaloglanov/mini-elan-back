package com.minielan.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AdvertisementResponse(
        Long id,
        String title,
        BigDecimal price,
        String city,
        String imagePath,
        String categoryName,
        LocalDateTime createdAt
) {
}
