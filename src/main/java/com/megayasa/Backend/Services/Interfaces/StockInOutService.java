package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.ViewModels.Requests.StockInOutRequestVm;
import com.megayasa.Backend.ViewModels.Responses.StockInOutResponseVm;

import java.util.List;

public interface StockInOutService {
    void createOrUpdateStockInOut(String stockId, StockInOutRequestVm stockInOutRequestVm);
//    void updateStockInOut(String id, StockInOutRequestVm stockInOutRequestVm);
    StockInOutResponseVm findStockInOutById(String id);
    List<StockInOutResponseVm> findStockInOuts();
    void deleteStockInOut(String id);
}
