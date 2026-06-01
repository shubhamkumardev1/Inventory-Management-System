package com.project.inventory_management_system.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantityInStock;

    @NotNull(message = "Minimum stock level is required")
    @Positive(message = "Minimum stock level must be positive")
    private Integer minimumStockLevel;

    @NotNull(message = "Category id is required")
    private Long categoryId;

    @NotNull(message = "Supplier id is required")
    private Long supplierId;
}
