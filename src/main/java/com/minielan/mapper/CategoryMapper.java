package com.minielan.mapper;

import com.minielan.dto.CategoryResponse;
import com.minielan.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryMapper {

     CategoryResponse toResponse(CategoryEntity entity);
}
