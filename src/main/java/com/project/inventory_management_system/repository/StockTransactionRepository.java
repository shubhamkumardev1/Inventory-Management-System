package com.project.inventory_management_system.repository;

import com.project.inventory_management_system.entity.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTransactionRepository
        extends JpaRepository<StockTransaction, Long> {
}