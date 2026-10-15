package com.minielan.controller;

import com.minielan.dto.AdvertisementCreateRequest;
import com.minielan.dto.AdvertisementDetailResponse;
import com.minielan.dto.AdvertisementResponse;
import com.minielan.service.AdvertisementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;


    @PostMapping
    public ResponseEntity<AdvertisementDetailResponse> createAdvertisement(@RequestBody @Valid AdvertisementCreateRequest request){
        AdvertisementDetailResponse advertisementDetailResponse = advertisementService.createAdvertisement(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(advertisementDetailResponse.id())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(advertisementDetailResponse);
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
