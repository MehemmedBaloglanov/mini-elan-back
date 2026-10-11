package com.minielan.service;

import com.minielan.dto.AdvertisementResponse;
import com.minielan.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService{

    private final AdvertisementRepository advertisementRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AdvertisementResponse> getAllAdvertisements() {
        return advertisementRepository.findAll(Sort.by("createdAt").descending())
                .stream()
                .map(advertisementEntity ->
                        new AdvertisementResponse(
                                advertisementEntity.getId(),
                                advertisementEntity.getTitle(),
                                advertisementEntity.getPrice(),
                                advertisementEntity.getCity(),
                                advertisementEntity.getImagePath(),
                                advertisementEntity.getCategory().getName(),
                                advertisementEntity.getCreatedAt()
                        )).toList();
    }
}
