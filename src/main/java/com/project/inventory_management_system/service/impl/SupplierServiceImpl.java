package com.project.inventory_management_system.service.impl;

import com.project.inventory_management_system.dto.request.SupplierRequestDto;
import com.project.inventory_management_system.dto.response.SupplierResponseDto;
import com.project.inventory_management_system.entity.Supplier;
import com.project.inventory_management_system.exception.ResourceNotFoundException;
import com.project.inventory_management_system.repository.SupplierRepository;
import com.project.inventory_management_system.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(
            SupplierRepository supplierRepository) {

        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierResponseDto createSupplier(
            SupplierRequestDto requestDto) {

        Supplier supplier = new Supplier();

        supplier.setName(requestDto.getName());
        supplier.setContactPerson(requestDto.getContactPerson());
        supplier.setEmail(requestDto.getEmail());
        supplier.setPhone(requestDto.getPhone());

        Supplier savedSupplier =
                supplierRepository.save(supplier);

        return new SupplierResponseDto(
                savedSupplier.getId(),
                savedSupplier.getName(),
                savedSupplier.getContactPerson(),
                savedSupplier.getEmail(),
                savedSupplier.getPhone()
        );
    }

    @Override
    public SupplierResponseDto getSupplierById(
            Long supplierId) {

        Supplier supplier =
                supplierRepository.findById(supplierId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Supplier not found with id "
                                                + supplierId));

        return new SupplierResponseDto(
                supplier.getId(),
                supplier.getName(),
                supplier.getContactPerson(),
                supplier.getEmail(),
                supplier.getPhone()
        );
    }

    @Override
    public List<SupplierResponseDto> getAllSuppliers() {

        return supplierRepository.findAll()
                .stream()
                .map(supplier ->
                        new SupplierResponseDto(
                                supplier.getId(),
                                supplier.getName(),
                                supplier.getContactPerson(),
                                supplier.getEmail(),
                                supplier.getPhone()
                        ))
                .toList();
    }

    @Override
    public SupplierResponseDto updateSupplier(
            Long supplierId,
            SupplierRequestDto requestDto) {

        Supplier supplier =
                supplierRepository.findById(supplierId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Supplier not found with id "
                                                + supplierId));

        supplier.setName(requestDto.getName());
        supplier.setContactPerson(requestDto.getContactPerson());
        supplier.setEmail(requestDto.getEmail());
        supplier.setPhone(requestDto.getPhone());

        Supplier updatedSupplier =
                supplierRepository.save(supplier);

        return new SupplierResponseDto(
                updatedSupplier.getId(),
                updatedSupplier.getName(),
                updatedSupplier.getContactPerson(),
                updatedSupplier.getEmail(),
                updatedSupplier.getPhone()
        );
    }

    @Override
    public void deleteSupplier(Long supplierId) {

        supplierRepository.deleteById(supplierId);
    }
}