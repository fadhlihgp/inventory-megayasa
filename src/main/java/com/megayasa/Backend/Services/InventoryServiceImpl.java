package com.megayasa.Backend.Services;

import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Exceptions.WarningException;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Repositories.InventoryRepository;
import com.megayasa.Backend.Services.Interfaces.InventoryService;
import com.megayasa.Backend.ViewModels.Requests.InventoryRequestVm;
import com.megayasa.Backend.ViewModels.Responses.InventoryResponseVm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void createInventory(InventoryRequestVm inventoryRequestVm) {
        Inventory inventoryByCode = inventoryRepository.findInventoryByCode(inventoryRequestVm.getCode());
        if (inventoryByCode != null) throw new WarningException("Kode barang sudah tersedia, silahkan cari kode lain");

        Inventory saveInventory = new Inventory(UUID.randomUUID().toString(), inventoryRequestVm.getName(),
                inventoryRequestVm.getCode(), (inventoryRequestVm.getStock() == null ? 0 : inventoryRequestVm.getStock()), inventoryRequestVm.getType(), null);

        try {
            inventoryRepository.save(saveInventory);
            InformationDialog.successMessage("Berhasil menambah data barang");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void updateInventoryByCode(String code, InventoryRequestVm inventoryRequestVm) {
        Inventory inventoryByCode = inventoryRepository.findInventoryByCode(code);
        if (inventoryByCode == null) throw new NotFoundException("Kode barang tidak ditemukan");

        inventoryByCode.setName(inventoryRequestVm.getName());
        inventoryByCode.setCode(inventoryRequestVm.getCode());
        inventoryByCode.setType(inventoryByCode.getType());
        inventoryByCode.setStock(inventoryRequestVm.getStock());

        try {
            inventoryRepository.save(inventoryByCode);
            InformationDialog.successMessage("Berhasil mengubah data barang");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void updateInventoryById(String inventoryId, InventoryRequestVm inventoryRequestVm) {
        Inventory inventoryByid = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new NotFoundException("Id Barang tidak ditemukan"));

        inventoryByid.setName(inventoryRequestVm.getName());
        inventoryByid.setCode(inventoryRequestVm.getCode());
        inventoryByid.setType(inventoryByid.getType());
        inventoryByid.setStock(inventoryRequestVm.getStock());

        try {
            inventoryRepository.save(inventoryByid);
            InformationDialog.successMessage("Berhasil mengubah data barang");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void deleteInventoryByIdOrCode(String idOrCode) {
        Inventory inventory = inventoryRepository.findInventoryByIdOrCode(idOrCode, idOrCode)
                .orElseThrow(() -> new NotFoundException("Barang tidak ditemukan"));

        try {
            inventoryRepository.delete(inventory);
            InformationDialog.deleteSuccess("Berhasil menghapus data barang");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }

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
        Inventory inventory = inventoryRepository.findInventoryByIdOrCode(codeOrId, codeOrId)
                .orElseThrow(() -> new NotFoundException("Data barang tidak ditemukan"));

        return new InventoryResponseVm(inventory.getId(), inventory.getName(), inventory.getCode() ,inventory.getStock(), inventory.getType());
    }

    @Override
    public Inventory findInventoryById(String inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new NotFoundException("Barang tidak ditemukan"));
    }
}
