package com.project.inventory_management_system.controller;

import com.project.inventory_management_system.dto.request.SupplierRequestDto;
import com.project.inventory_management_system.dto.response.SupplierResponseDto;
import com.project.inventory_management_system.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(
            SupplierService supplierService) {

        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<SupplierResponseDto>
    createSupplier(
            @Valid @RequestBody SupplierRequestDto requestDto) {

        return ResponseEntity.ok(
                supplierService.createSupplier(
                        requestDto));
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDto>>
    getAllSuppliers() {

        return ResponseEntity.ok(
                supplierService.getAllSuppliers());
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierResponseDto>
    getSupplierById(
            @PathVariable Long supplierId) {

        return ResponseEntity.ok(
                supplierService.getSupplierById(
                        supplierId));
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<SupplierResponseDto>
    updateSupplier(
            @PathVariable Long supplierId,
            @Valid
            @RequestBody SupplierRequestDto requestDto) {

        return ResponseEntity.ok(
                supplierService.updateSupplier(
                        supplierId,
                        requestDto));
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void>
    deleteSupplier(
            @PathVariable Long supplierId) {

        supplierService.deleteSupplier(
                supplierId);

        return ResponseEntity.noContent()
                .build();
    }
}