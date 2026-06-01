package com.project.inventory_management_system.dto.request;

import com.project.inventory_management_system.enums.Role;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

    private String name;

    private String email;

    private Role role;
}