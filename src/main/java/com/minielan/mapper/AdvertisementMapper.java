package com.minielan.mapper;

import com.minielan.dto.AdvertisementCreateRequest;
import com.minielan.dto.AdvertisementDetailResponse;
import com.minielan.dto.AdvertisementResponse;
import com.minielan.entity.AdvertisementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AdvertisementMapper {

    @Mapping(target = "categoryName" , source = "category.name")
    AdvertisementResponse toResponse(AdvertisementEntity entity);

    @Mapping(target = "categoryName" , source = "category.name")
    @Mapping(target = "userName" , source = "user.name")
    @Mapping(target = "userPhone" , source = "user.phone")
    AdvertisementDetailResponse toDetailResponse(AdvertisementEntity entity);

    @Mapping(target = "imagePath",ignore = true)
    @Mapping(target = "category",ignore = true)
    @Mapping(target = "user",ignore = true)
    AdvertisementEntity toEntityFromCreateRequest(AdvertisementCreateRequest request);
}
