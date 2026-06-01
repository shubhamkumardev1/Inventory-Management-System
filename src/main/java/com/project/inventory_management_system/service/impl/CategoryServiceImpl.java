package com.project.inventory_management_system.service.impl;

import com.project.inventory_management_system.dto.request.CategoryRequestDto;
import com.project.inventory_management_system.dto.response.CategoryResponseDto;
import com.project.inventory_management_system.entity.Category;
import com.project.inventory_management_system.exception.ResourceNotFoundException;
import com.project.inventory_management_system.repository.CategoryRepository;
import com.project.inventory_management_system.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(
            CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDto createCategory(
            CategoryRequestDto requestDto) {

        Category category = new Category();

        category.setName(requestDto.getName());

        Category savedCategory =
                categoryRepository.save(category);

        return new CategoryResponseDto(
                savedCategory.getId(),
                savedCategory.getName()
        );
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(category ->
                        new CategoryResponseDto(
                                category.getId(),
                                category.getName()
                        ))
                .toList();
    }

    @Override
    public CategoryResponseDto getCategoryById(
            Long categoryId) {

        Category category =
                categoryRepository.findById(categoryId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Category not found with id "
                                                + categoryId));

        return new CategoryResponseDto(
                category.getId(),
                category.getName()
        );
    }

    @Override
    public CategoryResponseDto updateCategory(
            Long categoryId,
            CategoryRequestDto requestDto) {

        Category category =
                categoryRepository.findById(categoryId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Category not found with id "
                                                + categoryId));

        category.setName(requestDto.getName());

        Category updatedCategory =
                categoryRepository.save(category);

        return new CategoryResponseDto(
                updatedCategory.getId(),
                updatedCategory.getName()
        );
    }

    @Override
    public void deleteCategory(Long categoryId) {

        categoryRepository.deleteById(categoryId);
    }
}