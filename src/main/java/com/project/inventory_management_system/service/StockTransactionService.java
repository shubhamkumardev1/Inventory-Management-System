package com.project.inventory_management_system.service;

import com.project.inventory_management_system.dto.request.StockTransactionRequestDto;
import com.project.inventory_management_system.dto.response.StockTransactionResponseDto;

import java.util.List;

public interface StockTransactionService {

    StockTransactionResponseDto addStock(
            StockTransactionRequestDto requestDto);

    StockTransactionResponseDto removeStock(
            StockTransactionRequestDto requestDto);

    List<StockTransactionResponseDto>
    getTransactionHistory();
}
