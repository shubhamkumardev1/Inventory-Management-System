package com.project.inventory_management_system.service;

import com.project.inventory_management_system.dto.request.ProductRequestDto;
import com.project.inventory_management_system.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(
            ProductRequestDto requestDto);

    ProductResponseDto getProductById(
            Long productId);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto updateProduct(
            Long productId,
            ProductRequestDto requestDto);

    void deleteProduct(
            Long productId);
}
