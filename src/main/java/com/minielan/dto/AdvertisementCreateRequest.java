package com.minielan.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AdvertisementCreateRequest(
                                        @NotBlank
                                        @Size(min = 5,max = 100)
                                        String title,

                                        @NotBlank
                                        @Size(max = 2000)
                                        String description,

                                        @NotNull
                                        @Positive
                                        @Digits(integer = 10, fraction = 2)
                                        BigDecimal price,

                                        @NotBlank
                                        @Size(max = 50)
                                        String city,

                                        @NotNull
                                        Long categoryId,

                                        @NotNull
                                        Long userId) {
}
