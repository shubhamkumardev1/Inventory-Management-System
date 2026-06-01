package com.project.inventory_management_system.dto.request;

import com.project.inventory_management_system.enums.TransactionType;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockTransactionRequestDto {

    private TransactionType transactionType;

    private Integer quantity;

    private Long productId;

    private Long employeeId;
}