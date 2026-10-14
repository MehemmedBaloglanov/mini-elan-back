package com.minielan.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AdvertisementCreateRequest(
                                        @NotBlank
                                        @Min(5)
                                        @Max(100)
                                        String title,

                                        @NotBlank
                                        @Max(2000)
                                        String description,

                                        @NotNull
                                        @Positive
                                        @Digits(integer = 10, fraction = 2)
                                        BigDecimal price,

                                        @NotBlank
                                        @Max(50)
                                        String city,

                                        @NotNull
                                        Long categoryId,

                                        @NotNull
                                        Long userId) {
}
