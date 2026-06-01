package com.project.inventory_management_system.service;

import com.project.inventory_management_system.dto.request.CategoryRequestDto;
import com.project.inventory_management_system.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(
            CategoryRequestDto requestDto);

    CategoryResponseDto getCategoryById(
            Long categoryId);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto updateCategory(
            Long categoryId,
            CategoryRequestDto requestDto);

    void deleteCategory(
            Long categoryId);
}
