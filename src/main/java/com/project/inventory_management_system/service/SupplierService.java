package com.project.inventory_management_system.service;

import com.project.inventory_management_system.dto.request.SupplierRequestDto;
import com.project.inventory_management_system.dto.response.SupplierResponseDto;

import java.util.List;

public interface SupplierService {

    SupplierResponseDto createSupplier(
            SupplierRequestDto requestDto);

    SupplierResponseDto getSupplierById(
            Long supplierId);

    List<SupplierResponseDto> getAllSuppliers();

    SupplierResponseDto updateSupplier(
            Long supplierId,
            SupplierRequestDto requestDto);

    void deleteSupplier(
            Long supplierId);
}
