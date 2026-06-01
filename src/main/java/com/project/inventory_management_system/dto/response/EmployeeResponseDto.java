package com.project.inventory_management_system.dto.response;

import com.project.inventory_management_system.enums.Role;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

    private Long id;

    private String name;

    private String email;

    private Role role;
}