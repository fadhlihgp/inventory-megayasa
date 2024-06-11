package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Services.Interfaces.StockInOutService;
import com.megayasa.Backend.ViewModels.Requests.StockInOutRequestVm;
import com.megayasa.Backend.ViewModels.Responses.StockInOutResponseVm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StockInOutController {
    private final StockInOutService stockInOutService;

    @Inject
    public StockInOutController(StockInOutService stockInOutService) {
        this.stockInOutService = stockInOutService;
    }

    public void createOrUpdateStockInOut(String stockId, StockInOutRequestVm stockInOutRequestVm){
        stockInOutService.createOrUpdateStockInOut(stockId, stockInOutRequestVm);
    }

//    public void updateStockInOut(String id, StockInOutRequestVm stockInOutRequestVm){
//        stockInOutService.updateStockInOut(id, stockInOutRequestVm);
//    }

    public StockInOutResponseVm findStockInOutById(String id){
        return stockInOutService.findStockInOutById(id);
    }

    public List<StockInOutResponseVm> findStockInOuts(){
        List<StockInOutResponseVm> stocks = new ArrayList<>(stockInOutService.findStockInOuts());
        stocks.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        return stocks;
    }

    public void deleteStockInOut(String id){
        stockInOutService.deleteStockInOut(id);
    }
}
