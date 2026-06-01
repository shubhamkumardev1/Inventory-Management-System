package com.project.inventory_management_system.dto.response;

import java.math.BigDecimal;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantityInStock;

    private Integer minimumStockLevel;

    private String categoryName;

    private String supplierName;
}