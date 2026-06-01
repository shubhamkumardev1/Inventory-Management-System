package com.project.inventory_management_system.dto.request;

import com.project.inventory_management_system.enums.TransactionType;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockTransactionRequestDto {

    @NotNull(message = "Transaction type is required")
    private TransactionType transactionType;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

    @NotNull(message = "Product id is required")
    private Long productId;

    @NotNull(message = "Employee id is required")
    private Long employeeId;
}