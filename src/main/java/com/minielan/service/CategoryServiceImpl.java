package com.minielan.service;

import com.minielan.dto.CategoryResponse;
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

    @Transactional(readOnly = true)
    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll(Sort.by("id"))
                .stream().map(categoryEntity ->
                        new CategoryResponse(
                                categoryEntity.getId(),
                                categoryEntity.getName())).toList();
    }
}
