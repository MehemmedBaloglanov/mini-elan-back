package com.minielan.repository;

import com.minielan.dto.AdvertisementResponse;
import com.minielan.entity.AdvertisementEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> {
    @EntityGraph(attributePaths = "category")
    List<AdvertisementEntity> findAll(Sort sort);
}
