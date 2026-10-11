package com.minielan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "advertisement")
public class AdvertisementEntity extends BaseEntity{

    @Column(name = "title", length = 100,nullable = false)
    private String title;

    @Column(name = "description", length = 2000, nullable = false)
    private String description;

    @Column(name = "price",precision = 12, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "image_path", length = 500)
    private String imagePath;

    @JoinColumn(name = "category_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
