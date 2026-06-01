package com.project.inventory_management_system.controller;

import com.project.inventory_management_system.dto.request.StockTransactionRequestDto;
import com.project.inventory_management_system.dto.response.StockTransactionResponseDto;
import com.project.inventory_management_system.service.StockTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class StockTransactionController {

    private final StockTransactionService
            stockTransactionService;

    public StockTransactionController(
            StockTransactionService stockTransactionService) {

        this.stockTransactionService =
                stockTransactionService;
    }

    @PostMapping("/stock-in")
    public ResponseEntity<StockTransactionResponseDto>
    addStock(
            @RequestBody
            StockTransactionRequestDto requestDto) {

        return ResponseEntity.ok(
                stockTransactionService
                        .addStock(requestDto));
    }

    @PostMapping("/stock-out")
    public ResponseEntity<StockTransactionResponseDto>
    removeStock(
            @RequestBody
            StockTransactionRequestDto requestDto) {

        return ResponseEntity.ok(
                stockTransactionService
                        .removeStock(requestDto));
    }

    @GetMapping
    public ResponseEntity<
            List<StockTransactionResponseDto>>
    getTransactionHistory() {

        return ResponseEntity.ok(
                stockTransactionService
                        .getTransactionHistory());
    }
}