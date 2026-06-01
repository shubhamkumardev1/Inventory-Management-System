package com.project.inventory_management_system.service.impl;

import com.project.inventory_management_system.dto.request.StockTransactionRequestDto;
import com.project.inventory_management_system.dto.response.StockTransactionResponseDto;
import com.project.inventory_management_system.entity.Employee;
import com.project.inventory_management_system.entity.Product;
import com.project.inventory_management_system.entity.StockTransaction;
import com.project.inventory_management_system.enums.TransactionType;
import com.project.inventory_management_system.repository.EmployeeRepository;
import com.project.inventory_management_system.repository.ProductRepository;
import com.project.inventory_management_system.repository.StockTransactionRepository;
import com.project.inventory_management_system.service.StockTransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockTransactionServiceImpl
        implements StockTransactionService {

    private final StockTransactionRepository
            stockTransactionRepository;

    private final ProductRepository
            productRepository;

    private final EmployeeRepository
            employeeRepository;

    public StockTransactionServiceImpl(
            StockTransactionRepository stockTransactionRepository,
            ProductRepository productRepository,
            EmployeeRepository employeeRepository) {

        this.stockTransactionRepository =
                stockTransactionRepository;

        this.productRepository =
                productRepository;

        this.employeeRepository =
                employeeRepository;
    }

    @Override
    public StockTransactionResponseDto addStock(
            StockTransactionRequestDto requestDto) {

        Product product =
                productRepository.findById(
                                requestDto.getProductId())
                        .orElseThrow();

        Employee employee =
                employeeRepository.findById(
                                requestDto.getEmployeeId())
                        .orElseThrow();

        product.setQuantityInStock(
                product.getQuantityInStock()
                        + requestDto.getQuantity());

        productRepository.save(product);

        StockTransaction transaction =
                new StockTransaction();

        transaction.setTransactionType(
                TransactionType.STOCK_IN);

        transaction.setQuantity(
                requestDto.getQuantity());

        transaction.setTransactionDate(
                LocalDateTime.now());

        transaction.setProduct(product);

        transaction.setEmployee(employee);

        StockTransaction savedTransaction =
                stockTransactionRepository.save(
                        transaction);

        return mapToResponse(savedTransaction);
    }

    @Override
    public StockTransactionResponseDto removeStock(
            StockTransactionRequestDto requestDto) {

        Product product =
                productRepository.findById(
                                requestDto.getProductId())
                        .orElseThrow();

        Employee employee =
                employeeRepository.findById(
                                requestDto.getEmployeeId())
                        .orElseThrow();

        if (requestDto.getQuantity()
                > product.getQuantityInStock()) {

            throw new RuntimeException(
                    "Insufficient stock available");
        }

        product.setQuantityInStock(
                product.getQuantityInStock()
                        - requestDto.getQuantity());

        productRepository.save(product);

        StockTransaction transaction =
                new StockTransaction();

        transaction.setTransactionType(
                TransactionType.STOCK_OUT);

        transaction.setQuantity(
                requestDto.getQuantity());

        transaction.setTransactionDate(
                LocalDateTime.now());

        transaction.setProduct(product);

        transaction.setEmployee(employee);

        StockTransaction savedTransaction =
                stockTransactionRepository.save(
                        transaction);

        return mapToResponse(savedTransaction);
    }

    @Override
    public List<StockTransactionResponseDto>
    getTransactionHistory() {

        return stockTransactionRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private StockTransactionResponseDto
    mapToResponse(
            StockTransaction transaction) {

        return new StockTransactionResponseDto(
                transaction.getId(),
                transaction.getTransactionType(),
                transaction.getQuantity(),
                transaction.getTransactionDate(),
                transaction.getProduct().getName(),
                transaction.getEmployee().getName()
        );
    }
}