package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Models.StockInOut;
import com.megayasa.Backend.Repositories.StockInOutRepository;
import com.megayasa.Backend.Services.Interfaces.InventoryService;
import com.megayasa.Backend.Services.Interfaces.StockInOutService;
import com.megayasa.Backend.ViewModels.Requests.InventoryRequestVm;
import com.megayasa.Backend.ViewModels.Requests.StockInOutRequestVm;
import com.megayasa.Backend.ViewModels.Responses.InventoryResponseVm;
import com.megayasa.Backend.ViewModels.Responses.StockInOutResponseVm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StockInOutServiceImpl implements StockInOutService {
    private final StockInOutRepository stockInOutRepository;
    private final InventoryService inventoryService;

    @Inject
    public StockInOutServiceImpl(StockInOutRepository stockInOutRepository, InventoryService inventoryService) {
        this.stockInOutRepository = stockInOutRepository;
        this.inventoryService = inventoryService;
    }

    private void createStockInOut(StockInOutRequestVm stockInOutReqVm) {
        Inventory findInventory = inventoryService.findInventoryById(stockInOutReqVm.getInventoryId());
        String formattedDate = new SimpleDateFormat("ddMMyyss").format(new Date());
        String id = stockInOutReqVm.getStatus() ? "IN-" + formattedDate + (stockInOutRepository.countStockInOutByStatusAndToday(true) + 1) :
                "OUT-"+formattedDate+(stockInOutRepository.countStockInOutByStatusAndToday(stockInOutReqVm.getStatus()) + 1);

        StockInOut stockInOut = new StockInOut();
        stockInOut.setId(id);
        stockInOut.setDate(stockInOutReqVm.getDate());
        stockInOut.setStatus(stockInOutReqVm.getStatus());
        stockInOut.setInventoryId(stockInOutReqVm.getInventoryId());
        stockInOut.setNote(stockInOutReqVm.getNote());
        stockInOut.setAmount(stockInOutReqVm.getAmount());

        if (stockInOutReqVm.getStatus()) {
            findInventory.setStock(findInventory.getStock() + stockInOutReqVm.getAmount());
        } else {
            findInventory.setStock(findInventory.getStock() - stockInOutReqVm.getAmount());
        }

        TransactionUtil.performTransaction(() -> {
            InventoryRequestVm saveUpdate = new InventoryRequestVm(findInventory.getCode(), findInventory.getName(), findInventory.getStock(), findInventory.getType());
            inventoryService.updateInventoryById(findInventory.getId(), saveUpdate);
            stockInOutRepository.create(stockInOut);
            String successMessage = stockInOutReqVm.getStatus() ? "Berhasil menambah data stok barang masuk" : "Berhasil menambah data stok barang keluar";
            InformationDialog.successMessage(successMessage);
        });
    }

    private void updateStockInOut(String stockId, StockInOutRequestVm stockInOutReqVm) {
        Inventory findInventory = inventoryService.findInventoryById(stockInOutReqVm.getInventoryId());

        StockInOut stockInOut = stockInOutRepository.findById(stockId).orElseThrow(() -> {throw new NotFoundException("Data stock tidak ditemukan");});
        stockInOut.setDate(stockInOutReqVm.getDate());
        stockInOut.setStatus(stockInOutReqVm.getStatus());
        stockInOut.setInventoryId(stockInOutReqVm.getInventoryId());
        stockInOut.setNote(stockInOutReqVm.getNote());
        stockInOut.setAmount(stockInOutReqVm.getAmount());

        if (stockInOutReqVm.getStatus()) {
            findInventory.setStock(findInventory.getStock() + stockInOutReqVm.getAmount());
        } else {
            findInventory.setStock(findInventory.getStock() - stockInOutReqVm.getAmount());
        }

        TransactionUtil.performTransaction(() -> {
            InventoryRequestVm saveUpdate = new InventoryRequestVm(findInventory.getCode(), findInventory.getName(), findInventory.getStock(), findInventory.getType());
            inventoryService.updateInventoryById(findInventory.getId(), saveUpdate);
            stockInOutRepository.update(stockInOut);
            String successMessage = stockInOutReqVm.getStatus() ? "Berhasil menambah data stok barang masuk" : "Berhasil menambah data stok barang keluar";
            InformationDialog.successMessage(successMessage);
        });
    }
    @Override
    public void createOrUpdateStockInOut(String stockId, StockInOutRequestVm stockInOutReqVm) {
        ValidationUtils.validate(stockInOutReqVm);
        if (stockId == null) {
            createStockInOut(stockInOutReqVm);
        } else {
            updateStockInOut(stockId, stockInOutReqVm);
        }
    }

    @Override
    public StockInOutResponseVm findStockInOutById(String id) {
        StockInOut findById = stockInOutRepository.findById(id).orElseThrow(() -> new NotFoundException("Data stok masuk/keluar tidak ditemukan"));
        InventoryResponseVm resultInv = findAllInventories().stream().filter(i -> i.getId().equals(findById.getInventoryId())).findFirst().orElse(null);
        return new StockInOutResponseVm(findById.getId(), findById.getDate(), findById.getAmount(),
                findById.getStatus(), findById.getNote(), findById.getInventoryId(), resultInv.getName(), resultInv.getCode());
    }

    @Override
    public List<StockInOutResponseVm> findStockInOuts() {
        List<StockInOut> stockInOuts = stockInOutRepository.findAll();
        return stockInOuts.stream().map(s -> {
            InventoryResponseVm resultInv = findAllInventories().stream().filter(i -> i.getId().equals(s.getInventoryId())).findFirst().orElse(null);
            return new StockInOutResponseVm(s.getId(), s.getDate(), s.getAmount(),
                    s.getStatus(), s.getNote(), s.getInventoryId(), resultInv.getName(), resultInv.getCode());
        }).toList();
    }

    @Override
    public void deleteStockInOut(String id) {
        StockInOut stockInOut = stockInOutRepository.findById(id).orElseThrow(() -> new NotFoundException("Data stok masuk/keluar tidak ditemukan"));
        Inventory findInventory = inventoryService.findInventoryById(stockInOut.getInventoryId());

        if (!stockInOut.getStatus()) {
            findInventory.setStock(findInventory.getStock() - stockInOut.getAmount());
        } else {
            findInventory.setStock(findInventory.getStock() + stockInOut.getAmount());
        }

        TransactionUtil.performTransaction(() -> {
            InventoryRequestVm saveUpdate = new InventoryRequestVm(findInventory.getCode(), findInventory.getName(), findInventory.getStock(), findInventory.getType());
            inventoryService.updateInventoryById(stockInOut.getInventoryId(), saveUpdate);
            stockInOutRepository.delete(stockInOut);
            String successMessage = stockInOut.getStatus() ? "Berhasil menghapus barang masuk" : "Berhasil manghapus barang keluar";
            InformationDialog.deleteSuccess(successMessage);
        });
    }

    private List<InventoryResponseVm> findAllInventories() {
        return inventoryService.findAllInventories();
    }
}
