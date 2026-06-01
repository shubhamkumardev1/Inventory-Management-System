package com.project.inventory_management_system.service;

import com.project.inventory_management_system.dto.request.EmployeeRequestDto;
import com.project.inventory_management_system.dto.response.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto createEmployee(
            EmployeeRequestDto requestDto);

    EmployeeResponseDto getEmployeeById(
            Long employeeId);

    List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto updateEmployee(
            Long employeeId,
            EmployeeRequestDto requestDto);

    void deleteEmployee(
            Long employeeId);
}
