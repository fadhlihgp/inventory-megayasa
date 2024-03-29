package com.megayasa.Backend.Services;

import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Models.StockInOut;
import com.megayasa.Backend.Repositories.StockInOutRepository;
import com.megayasa.Backend.Services.Interfaces.InventoryService;
import com.megayasa.Backend.Services.Interfaces.StockInOutService;
import com.megayasa.Backend.ViewModels.Requests.InventoryRequestVm;
import com.megayasa.Backend.ViewModels.Requests.StockInOutRequestVm;
import com.megayasa.Backend.ViewModels.Responses.StockInOutResponseVm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StockInOutServiceImpl implements StockInOutService {
    private final StockInOutRepository stockInOutRepository;
    private final InventoryService inventoryService;

    @Autowired
    public StockInOutServiceImpl(StockInOutRepository stockInOutRepository, InventoryService inventoryService) {
        this.stockInOutRepository = stockInOutRepository;
        this.inventoryService = inventoryService;
    }

    @Override
    public void createOrUpdateStockInOut(String stockId, StockInOutRequestVm stockInOutReqVm) {
        ValidationUtils.validate(stockInOutReqVm);
        Inventory findInventory = inventoryService.findInventoryById(stockInOutReqVm.getInventoryId());
        String formattedDate = new SimpleDateFormat("ddMMyyss").format(new Date());
        String id = stockInOutReqVm.getStatus() ? "IN-" + formattedDate + (stockInOutRepository.countStockInOutByStatusAndToday(true) + 1) :
                "OUT-"+formattedDate+(stockInOutRepository.countStockInOutByStatusAndToday(false) + 1);

        StockInOut stockInOut = new StockInOut();
        if (stockId == null) {
            stockInOut.setId(id);
        } else {
            stockInOut = stockInOutRepository.findById(stockId).orElseThrow(() -> new NotFoundException("Data stok masuk/keluar tidak ditemukan"));
        }

        try {
            if (!stockInOutReqVm.getStatus()) {
                findInventory.setStock(findInventory.getStock() - stockInOutReqVm.getAmount());
            } else {
                findInventory.setStock(findInventory.getStock() + stockInOutReqVm.getAmount());
            }

            stockInOut.setDate(stockInOutReqVm.getDate());
            stockInOut.setStatus(stockInOut.getStatus());
            stockInOut.setNote(stockInOut.getNote());
            stockInOut.setAmount(stockInOut.getAmount());

            InventoryRequestVm saveUpdate = new InventoryRequestVm(findInventory.getCode(), findInventory.getName(), findInventory.getStock(), findInventory.getType());
            inventoryService.updateInventoryById(stockInOutReqVm.getInventoryId(), saveUpdate);
            stockInOutRepository.save(stockInOut);

            String successMessage = stockInOutReqVm.getStatus() ? "Berhasil menambah stok barang" : "Berhasil mengurangi stok barang";

            if (stockId != null) {
                successMessage = "Berhasil memperbarui stok barang";
            }

            InformationDialog.successMessage(successMessage);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }

    }

//    @Override
//    public void updateStockInOut(String id, StockInOutRequestVm stockInOutReqVm) {
//        ValidationUtils.validate(stockInOutReqVm);
//        Inventory findInventory = inventoryService.findInventoryById(stockInOutReqVm.getInventoryId());
//
//    }

    @Override
    public StockInOutResponseVm findStockInOutById(String id) {
        StockInOut findById = stockInOutRepository.findById(id).orElseThrow(() -> new NotFoundException("Data stok masuk/keluar tidak ditemukan"));
        return new StockInOutResponseVm(findById.getId(), findById.getDate(), findById.getAmount(),
                findById.getStatus(), findById.getNote(), findById.getInventory().getId(), findById.getInventory().getName());
    }

    @Override
    public List<StockInOutResponseVm> findStockInOuts() {
        List<StockInOut> stockInOuts = stockInOutRepository.findAll();
        return stockInOuts.stream().map(s -> new StockInOutResponseVm(s.getId(), s.getDate(), s.getAmount(),
                s.getStatus(), s.getNote(), s.getInventory().getId(), s.getInventory().getName())).toList();
    }

    @Override
    public void deleteStockInOut(String id) {
        StockInOut stockInOut = stockInOutRepository.findById(id).orElseThrow(() -> new NotFoundException("Data stok masuk/keluar tidak ditemukan"));
        Inventory findInventory = inventoryService.findInventoryById(stockInOut.getInventory().getId());

        if (!stockInOut.getStatus()) {
            findInventory.setStock(findInventory.getStock() - stockInOut.getAmount());
        } else {
            findInventory.setStock(findInventory.getStock() + stockInOut.getAmount());
        }

        try {
            InventoryRequestVm saveUpdate = new InventoryRequestVm(findInventory.getCode(), findInventory.getName(), findInventory.getStock(), findInventory.getType());
            inventoryService.updateInventoryById(stockInOut.getInventory().getId(), saveUpdate);
            stockInOutRepository.delete(stockInOut);
            String successMessage = stockInOut.getStatus() ? "Berhasil menghapus barang masuk" : "Berhasil manghapus barang keluar";
            InformationDialog.deleteSuccess(successMessage);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }
}
