package com.minielan.repository;

import com.minielan.entity.AdvertisementEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> {
    @EntityGraph(attributePaths = "category")
    List<AdvertisementEntity> findAll(Sort sort);

    @EntityGraph(attributePaths = {"category","user"})
    Optional<AdvertisementEntity> findById(Long id);
}
