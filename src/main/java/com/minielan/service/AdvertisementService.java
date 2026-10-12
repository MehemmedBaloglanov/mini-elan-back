package com.minielan.service;

import com.minielan.dto.AdvertisementDetailResponse;
import com.minielan.dto.AdvertisementResponse;

import java.util.List;

public interface AdvertisementService {

    List<AdvertisementResponse> getAllAdvertisements();

    AdvertisementDetailResponse getAdvertisementById(Long id);
}
