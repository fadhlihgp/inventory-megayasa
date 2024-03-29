package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.ViewModels.Requests.InventoryRequestVm;
import com.megayasa.Backend.ViewModels.Responses.InventoryResponseVm;

import java.util.List;

public interface InventoryService {
    void createInventory(InventoryRequestVm inventoryRequestVm);
    void updateInventoryByCode(String code, InventoryRequestVm inventoryRequestVm);
    void updateInventoryById(String inventoryId, InventoryRequestVm inventoryRequestVm);
    void deleteInventoryByIdOrCode(String codeOrId);
    List<InventoryResponseVm> findAllInventories();
    InventoryResponseVm findInventoryByIdOrCode(String codeOrId);
}
