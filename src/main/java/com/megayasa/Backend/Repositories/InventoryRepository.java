package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository {
    int inventoryTotal();
    Optional<Inventory> findById(String id);
    void delete(Inventory inventory);
    List<Inventory> findAll();
    void create(Inventory inventory);
    void update(Inventory inventory);
    Optional<Inventory> findInventoryByIdOrCode(String idOrCode);
    Inventory findInventoryByCode(String code);
}
