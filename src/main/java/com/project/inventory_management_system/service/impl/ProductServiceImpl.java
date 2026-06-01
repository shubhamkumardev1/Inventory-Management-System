package com.project.inventory_management_system.service.impl;

import com.project.inventory_management_system.dto.request.ProductRequestDto;
import com.project.inventory_management_system.dto.response.ProductResponseDto;
import com.project.inventory_management_system.entity.Category;
import com.project.inventory_management_system.entity.Product;
import com.project.inventory_management_system.entity.Supplier;
import com.project.inventory_management_system.exception.ResourceNotFoundException;
import com.project.inventory_management_system.repository.CategoryRepository;
import com.project.inventory_management_system.repository.ProductRepository;
import com.project.inventory_management_system.repository.SupplierRepository;
import com.project.inventory_management_system.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final SupplierRepository supplierRepository;

    public ProductServiceImpl(
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
            SupplierRepository supplierRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ProductResponseDto createProduct(
            ProductRequestDto requestDto) {

        Category category =
                categoryRepository.findById(
                                requestDto.getCategoryId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Category not found with id "
                                                + requestDto.getCategoryId()));

        Supplier supplier =
                supplierRepository.findById(
                                requestDto.getSupplierId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Supplier not found with id "
                                                + requestDto.getSupplierId()));

        Product product = new Product();

        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setPrice(requestDto.getPrice());
        product.setQuantityInStock(
                requestDto.getQuantityInStock());
        product.setMinimumStockLevel(
                requestDto.getMinimumStockLevel());

        product.setCategory(category);
        product.setSupplier(supplier);

        Product savedProduct =
                productRepository.save(product);

        return mapToResponse(savedProduct);
    }

    @Override
    public ProductResponseDto getProductById(
            Long productId) {

        Product product =
                productRepository.findById(productId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Product not found with id "
                                                + productId));

        return mapToResponse(product);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProductResponseDto updateProduct(
            Long productId,
            ProductRequestDto requestDto) {

        Product product =
                productRepository.findById(productId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Product not found with id "
                                                + productId));

        Category category =
                categoryRepository.findById(
                                requestDto.getCategoryId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Category not found with id "
                                                + requestDto.getCategoryId()));

        Supplier supplier =
                supplierRepository.findById(
                                requestDto.getSupplierId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Supplier not found with id "
                                                + requestDto.getSupplierId()));

        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setPrice(requestDto.getPrice());
        product.setQuantityInStock(
                requestDto.getQuantityInStock());
        product.setMinimumStockLevel(
                requestDto.getMinimumStockLevel());

        product.setCategory(category);
        product.setSupplier(supplier);

        Product updatedProduct =
                productRepository.save(product);

        return mapToResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(
            Long productId) {

        productRepository.deleteById(productId);
    }

    private ProductResponseDto mapToResponse(
            Product product) {

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantityInStock(),
                product.getMinimumStockLevel(),
                product.getCategory().getName(),
                product.getSupplier().getName()
        );
    }
}