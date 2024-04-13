package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Exceptions.WarningException;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Repositories.InventoryRepository;
import com.megayasa.Backend.Services.Interfaces.InventoryService;
import com.megayasa.Backend.ViewModels.Requests.InventoryRequestVm;
import com.megayasa.Backend.ViewModels.Responses.InventoryResponseVm;

import java.util.List;
import java.util.UUID;

public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Inject
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void createInventory(InventoryRequestVm inventoryRequestVm) {
        ValidationUtils.validate(inventoryRequestVm);
        Inventory inventoryByCode = inventoryRepository.findInventoryByCode(inventoryRequestVm.getCode());
        if (inventoryByCode != null) throw new WarningException("Kode barang sudah tersedia, silahkan cari kode lain");

        Inventory saveInventory = new Inventory(UUID.randomUUID().toString(), inventoryRequestVm.getName(),
                inventoryRequestVm.getCode(), (inventoryRequestVm.getStock() == null ? 0 : inventoryRequestVm.getStock()), inventoryRequestVm.getType());

        TransactionUtil.performTransaction(() -> {
            inventoryRepository.create(saveInventory);
            InformationDialog.successMessage("Berhasil menambah data barang");
        });
    }

    @Override
    public void updateInventoryByCode(String code, InventoryRequestVm inventoryRequestVm) {
        ValidationUtils.validate(inventoryRequestVm);
        Inventory inventoryByCode = inventoryRepository.findInventoryByCode(code);
        if (inventoryByCode == null) throw new NotFoundException("Kode barang tidak ditemukan");

        inventoryByCode.setName(inventoryRequestVm.getName());
        inventoryByCode.setCode(inventoryRequestVm.getCode());
        inventoryByCode.setType(inventoryByCode.getType());
        inventoryByCode.setStock(inventoryRequestVm.getStock());

        TransactionUtil.performTransaction(() -> {
            inventoryRepository.update(inventoryByCode);
            InformationDialog.successMessage("Berhasil mengubah data barang");
        });
    }

    @Override
    public void updateInventoryById(String inventoryId, InventoryRequestVm inventoryRequestVm) {
        ValidationUtils.validate(inventoryRequestVm);
        Inventory inventoryByid = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new NotFoundException("Id Barang tidak ditemukan"));

        inventoryByid.setName(inventoryRequestVm.getName());
        inventoryByid.setCode(inventoryRequestVm.getCode());
        inventoryByid.setType(inventoryByid.getType());
        inventoryByid.setStock(inventoryRequestVm.getStock());

        TransactionUtil.performTransaction(() -> {
            inventoryRepository.update(inventoryByid);
            InformationDialog.successMessage("Berhasil mengubah data barang");
        });
    }

    @Override
    public void deleteInventoryByIdOrCode(String idOrCode) {
                Inventory inventory = inventoryRepository.findInventoryByIdOrCode(idOrCode)
                .orElseThrow(() -> new NotFoundException("Barang tidak ditemukan"));

        TransactionUtil.performTransaction(() -> {
            inventoryRepository.delete(inventory);
            InformationDialog.deleteSuccess("Berhasil menghapus data barang");
        });
    }

    @Override
    public List<InventoryResponseVm> findAllInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();

        return inventories.stream().map(i -> {
            InventoryResponseVm responseVm = new InventoryResponseVm();
            responseVm.setId(i.getId());
            responseVm.setName(i.getName());
            responseVm.setCode(i.getCode());
            responseVm.setType(i.getType());
            responseVm.setStock(i.getStock());
            return responseVm;
        }).toList();
    }

    @Override
    public InventoryResponseVm findInventoryByIdOrCode(String codeOrId) {
        Inventory inventory = inventoryRepository.findInventoryByIdOrCode(codeOrId)
                .orElseThrow(() -> new NotFoundException("Data barang tidak ditemukan"));

        return new InventoryResponseVm(inventory.getId(), inventory.getName(), inventory.getCode() ,inventory.getStock(), inventory.getType());
    }

    @Override
    public Inventory findInventoryById(String inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new NotFoundException("Barang tidak ditemukan"));
    }
}
