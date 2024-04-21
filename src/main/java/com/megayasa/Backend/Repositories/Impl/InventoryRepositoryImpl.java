package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Repositories.InventoryRepository;
import com.megayasa.Backend.Repositories.QueryRepository;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InventoryRepositoryImpl implements InventoryRepository {
    private final QueryRepository<Inventory, String> queryRepository;

    @Inject
    public InventoryRepositoryImpl(Connection connection) {
        queryRepository = new QueryRepositoryImpl<>(Inventory.class, connection);
    }

    @Override
    public Optional<Inventory> findById(String id) {
        return queryRepository.findById(id);
    }

    @Override
    public void delete(Inventory inventory) {
        queryRepository.deleteById(inventory.getId());
    }

    @Override
    public List<Inventory> findAll() {
        return queryRepository.findAll();
    }

    @Override
    public void create(Inventory inventory) {
        queryRepository.save(inventory);
    }

    @Override
    public void update(Inventory inventory) {
        queryRepository.update(inventory);
    }


    @Override
    public Optional<Inventory> findInventoryByIdOrCode(String idOrCode) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("code", idOrCode);
        filters.put("id", idOrCode);
        return queryRepository.findOneByFilter(filters, "OR");
    }

    @Override
    public Inventory findInventoryByCode(String code) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("code", code);
        return queryRepository.findOneByFilter(filters, "AND").orElse(null);
    }
}
