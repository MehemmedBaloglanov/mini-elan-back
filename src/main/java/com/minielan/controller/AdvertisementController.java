package com.minielan.controller;

import com.minielan.dto.AdvertisementCreateRequest;
import com.minielan.dto.AdvertisementDetailResponse;
import com.minielan.dto.AdvertisementResponse;
import com.minielan.service.AdvertisementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;


    @PostMapping
    public AdvertisementDetailResponse createAdvertisement(@RequestBody @Valid AdvertisementCreateRequest request){
        return advertisementService.createAdvertisement(request);
    }


    @GetMapping
    public List<AdvertisementResponse> getAllAdvertisements(){
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("/{id}")
    public AdvertisementDetailResponse getAdvertisement(@PathVariable Long id){
        return advertisementService.getAdvertisementById(id);
    }
}
