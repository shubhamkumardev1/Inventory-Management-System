package com.project.inventory_management_system.dto.response;

import com.project.inventory_management_system.enums.TransactionType;

import java.time.LocalDateTime;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StockTransactionResponseDto {

    private Long id;

    private TransactionType transactionType;

    private Integer quantity;

    private LocalDateTime transactionDate;

    private String productName;

    private String employeeName;
}