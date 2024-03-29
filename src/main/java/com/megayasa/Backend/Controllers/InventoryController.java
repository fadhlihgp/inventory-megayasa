package com.megayasa.Backend.Controllers;

import com.megayasa.Backend.Services.Interfaces.InventoryService;
import com.megayasa.Backend.ViewModels.Requests.InventoryRequestVm;
import com.megayasa.Backend.ViewModels.Responses.InventoryResponseVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void createInventory(InventoryRequestVm inventoryRequestVm){
        inventoryService.createInventory(inventoryRequestVm);
    }

    public void updateInventoryByCode(String code, InventoryRequestVm inventoryRequestVm){
        inventoryService.updateInventoryByCode(code, inventoryRequestVm);
    }

    public void updateInventoryById(String inventoryId, InventoryRequestVm inventoryRequestVm){
        inventoryService.updateInventoryById(inventoryId, inventoryRequestVm);
    }

    public void deleteInventoryByIdOrCode(String codeOrId){
        inventoryService.deleteInventoryByIdOrCode(codeOrId);
    }

    public List<InventoryResponseVm> findAllInventories(){
        return inventoryService.findAllInventories();
    }

    public InventoryResponseVm findInventoryByIdOrCode(String codeOrId){
        return inventoryService.findInventoryByIdOrCode(codeOrId);
    }
}
