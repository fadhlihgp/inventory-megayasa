package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Services.Interfaces.InventoryService;
import com.megayasa.Backend.ViewModels.Requests.InventoryRequestVm;
import com.megayasa.Backend.ViewModels.Responses.InventoryResponseVm;

import java.util.Comparator;
import java.util.List;

public class InventoryController {
    private final InventoryService inventoryService;

    @Inject
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
        InformationDialog.successMessage("Berhasil mengubah data barang");
    }

    public void deleteInventoryByIdOrCode(String codeOrId){
        inventoryService.deleteInventoryByIdOrCode(codeOrId);
    }

    public List<Inventory> findAllInventories(){
        List<Inventory> inventories = inventoryService.findAllInventories();
        inventories.sort(new Comparator<Inventory>() {
            @Override
            public int compare(Inventory o1, Inventory o2) {
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        return  inventories;
    }

    public InventoryResponseVm findInventoryByIdOrCode(String codeOrId){
        return inventoryService.findInventoryByIdOrCode(codeOrId);
    }
}
