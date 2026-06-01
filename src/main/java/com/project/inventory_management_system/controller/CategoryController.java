package com.project.inventory_management_system.controller;

import com.project.inventory_management_system.dto.request.CategoryRequestDto;
import com.project.inventory_management_system.dto.response.CategoryResponseDto;
import com.project.inventory_management_system.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(
            CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto>
    createCategory(
            @RequestBody CategoryRequestDto requestDto) {

        return ResponseEntity.ok(
                categoryService.createCategory(
                        requestDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>>
    getAllCategories() {

        return ResponseEntity.ok(
                categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto>
    getCategoryById(
            @PathVariable Long categoryId) {

        return ResponseEntity.ok(
                categoryService.getCategoryById(
                        categoryId));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto>
    updateCategory(
            @PathVariable Long categoryId,
            @RequestBody CategoryRequestDto requestDto) {

        return ResponseEntity.ok(
                categoryService.updateCategory(
                        categoryId,
                        requestDto));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void>
    deleteCategory(
            @PathVariable Long categoryId) {

        categoryService.deleteCategory(
                categoryId);

        return ResponseEntity.noContent()
                .build();
    }
}