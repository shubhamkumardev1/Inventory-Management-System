package com.project.inventory_management_system.dto.response;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponseDto {

    private Long id;

    private String name;

    private String contactPerson;

    private String email;

    private String phone;
}
