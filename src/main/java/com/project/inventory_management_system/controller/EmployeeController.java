package com.project.inventory_management_system.controller;

import com.project.inventory_management_system.dto.request.EmployeeRequestDto;
import com.project.inventory_management_system.dto.response.EmployeeResponseDto;
import com.project.inventory_management_system.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(
            EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto>
    createEmployee(
           @Valid @RequestBody EmployeeRequestDto requestDto) {

        return ResponseEntity.ok(
                employeeService.createEmployee(
                        requestDto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>>
    getAllEmployees() {

        return ResponseEntity.ok(
                employeeService.getAllEmployees());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto>
    getEmployeeById(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(
                        employeeId));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto>
    updateEmployee(
            @PathVariable Long employeeId,
            @Valid
            @RequestBody EmployeeRequestDto requestDto) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(
                        employeeId,
                        requestDto));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void>
    deleteEmployee(
            @PathVariable Long employeeId) {

        employeeService.deleteEmployee(
                employeeId);

        return ResponseEntity.noContent()
                .build();
    }
}