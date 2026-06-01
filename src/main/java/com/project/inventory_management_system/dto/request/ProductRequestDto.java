package com.project.inventory_management_system.dto.request;

import java.math.BigDecimal;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantityInStock;

    private Integer minimumStockLevel;

    private Long categoryId;

    private Long supplierId;
}
