package com.minielan.controller;

import com.minielan.dto.AdvertisementDetailResponse;
import com.minielan.dto.AdvertisementResponse;
import com.minielan.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping
    public List<AdvertisementResponse> getAllAdvertisements(){
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("/{id}")
    public AdvertisementDetailResponse getAdvertisement(@PathVariable Long id){
        return advertisementService.getAdvertisementById(id);
    }
}
