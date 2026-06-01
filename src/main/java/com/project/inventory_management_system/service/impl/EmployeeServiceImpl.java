package com.project.inventory_management_system.service.impl;

import com.project.inventory_management_system.dto.request.EmployeeRequestDto;
import com.project.inventory_management_system.dto.response.EmployeeResponseDto;
import com.project.inventory_management_system.entity.Employee;
import com.project.inventory_management_system.exception.ResourceNotFoundException;
import com.project.inventory_management_system.repository.EmployeeRepository;
import com.project.inventory_management_system.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDto createEmployee(
            EmployeeRequestDto requestDto) {

        Employee employee = new Employee();

        employee.setName(requestDto.getName());
        employee.setEmail(requestDto.getEmail());
        employee.setRole(requestDto.getRole());

        Employee savedEmployee =
                employeeRepository.save(employee);

        return new EmployeeResponseDto(
                savedEmployee.getId(),
                savedEmployee.getName(),
                savedEmployee.getEmail(),
                savedEmployee.getRole()
        );
    }

    @Override
    public EmployeeResponseDto getEmployeeById(
            Long employeeId) {

        Employee employee =
                employeeRepository.findById(employeeId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found with id "
                                                + employeeId));

        return new EmployeeResponseDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getRole()
        );
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(employee ->
                        new EmployeeResponseDto(
                                employee.getId(),
                                employee.getName(),
                                employee.getEmail(),
                                employee.getRole()
                        ))
                .toList();
    }

    @Override
    public EmployeeResponseDto updateEmployee(
            Long employeeId,
            EmployeeRequestDto requestDto) {

        Employee employee =
                employeeRepository.findById(employeeId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found with id "
                                                + employeeId));

        employee.setName(requestDto.getName());
        employee.setEmail(requestDto.getEmail());
        employee.setRole(requestDto.getRole());

        Employee updatedEmployee =
                employeeRepository.save(employee);

        return new EmployeeResponseDto(
                updatedEmployee.getId(),
                updatedEmployee.getName(),
                updatedEmployee.getEmail(),
                updatedEmployee.getRole()
        );
    }

    @Override
    public void deleteEmployee(
            Long employeeId) {

        employeeRepository.deleteById(employeeId);
    }
}