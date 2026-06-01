package com.project.inventory_management_system.dto.request;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequestDto {

    private String name;

    private String contactPerson;

    private String email;

    private String phone;
}
