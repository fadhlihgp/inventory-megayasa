package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    void deleteInventoryByIdOrCode(String id, String code);
    Optional<Inventory> findInventoryByIdOrCode(String id, String code);
    Inventory findInventoryByCode(String code);
}
