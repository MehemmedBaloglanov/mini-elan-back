package com.minielan.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AdvertisementDetailResponse(
        Long id,
        String title,
        String description,
        BigDecimal price,
        String city,
        String imagePath,
        String categoryName,
        String userName,
        String userPhone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
        ) {
}
