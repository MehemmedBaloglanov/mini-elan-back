package com.minielan.service;

import com.minielan.dto.AdvertisementDetailResponse;
import com.minielan.dto.AdvertisementResponse;
import com.minielan.exception.AdvertisementNotFoundException;
import com.minielan.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional(readOnly = true)
    public AdvertisementDetailResponse getAdvertisementWithId(Long id) {
       return advertisementRepository.findById(id)
                        .map(advertisementEntity ->
                                new AdvertisementDetailResponse(
                                        advertisementEntity.getId(),
                                        advertisementEntity.getTitle(),
                                        advertisementEntity.getDescription(),
                                        advertisementEntity.getPrice(),
                                        advertisementEntity.getCity(),
                                        advertisementEntity.getImagePath(),
                                        advertisementEntity.getCategory().getName(),
                                        advertisementEntity.getUser().getName(),
                                        advertisementEntity.getUser().getPhone(),
                                        advertisementEntity.getCreatedAt(),
                                        advertisementEntity.getUpdatedAt()
                                )).orElseThrow(()-> new AdvertisementNotFoundException("Advertisement not found with: " + id));
    }
}
