package com.minielan.service;

import com.minielan.dto.CategoryResponse;
import com.minielan.entity.CategoryEntity;
import com.minielan.mapper.CategoryMapper;
import com.minielan.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional(readOnly = true)
    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll(Sort.by("id"))
                .stream().map(categoryMapper::toResponse).toList();
    }
}
