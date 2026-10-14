package com.minielan.service;

import com.minielan.dto.AdvertisementCreateRequest;
import com.minielan.dto.AdvertisementDetailResponse;
import com.minielan.dto.AdvertisementResponse;
import com.minielan.entity.AdvertisementEntity;
import com.minielan.entity.CategoryEntity;
import com.minielan.entity.UserEntity;
import com.minielan.exception.AdvertisementNotFoundException;
import com.minielan.exception.CategoryNotFoundException;
import com.minielan.exception.UserNotFoundException;
import com.minielan.mapper.AdvertisementMapper;
import com.minielan.repository.AdvertisementRepository;
import com.minielan.repository.CategoryRepository;
import com.minielan.repository.UserRepository;
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

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;


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

    @Override
    @Transactional
    public AdvertisementDetailResponse createAdvertisement(AdvertisementCreateRequest request) {
        CategoryEntity category = categoryRepository.findById(request.categoryId())
                .orElseThrow(()->new CategoryNotFoundException(request.categoryId()));

        UserEntity user = userRepository.findById(request.userId())
                .orElseThrow(()->new UserNotFoundException(request.userId()));

        AdvertisementEntity advertisementEntity  = advertisementMapper.toEntityFromCreateRequest(request);

        advertisementEntity.setCategory(category);
        advertisementEntity.setUser(user);

        advertisementRepository.save(advertisementEntity);

        return advertisementMapper.toDetailResponse(advertisementEntity);
    }
}
