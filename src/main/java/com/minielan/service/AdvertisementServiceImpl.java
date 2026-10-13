package com.minielan.service;

import com.minielan.dto.AdvertisementDetailResponse;
import com.minielan.dto.AdvertisementResponse;
import com.minielan.exception.AdvertisementNotFoundException;
import com.minielan.mapper.AdvertisementMapper;
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

    private final AdvertisementMapper advertisementMapper;


    @Override
    @Transactional(readOnly = true)
    public List<AdvertisementResponse> getAllAdvertisements() {
        return advertisementRepository.findAll(Sort.by("createdAt").descending())
                .stream()
                .map(advertisementMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AdvertisementDetailResponse getAdvertisementById(Long id) {
       return advertisementRepository.findById(id)
                        .map(advertisementMapper::toDetailResponse).orElseThrow(()-> new AdvertisementNotFoundException(id));
    }
}
