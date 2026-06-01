package com.project.inventory_management_system.controller;

import com.project.inventory_management_system.dto.request.ProductRequestDto;
import com.project.inventory_management_system.dto.response.ProductResponseDto;
import com.project.inventory_management_system.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService) {

        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto>
    createProduct(
            @RequestBody ProductRequestDto requestDto) {

        return ResponseEntity.ok(
                productService.createProduct(
                        requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>>
    getAllProducts() {

        return ResponseEntity.ok(
                productService.getAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto>
    getProductById(
            @PathVariable Long productId) {

        return ResponseEntity.ok(
                productService.getProductById(
                        productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDto>
    updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductRequestDto requestDto) {

        return ResponseEntity.ok(
                productService.updateProduct(
                        productId,
                        requestDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void>
    deleteProduct(
            @PathVariable Long productId) {

        productService.deleteProduct(
                productId);

        return ResponseEntity.noContent()
                .build();
    }
}