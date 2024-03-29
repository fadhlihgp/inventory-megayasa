package com.megayasa.Backend.Controllers;

import com.megayasa.Backend.Services.Interfaces.StockInOutService;
import com.megayasa.Backend.ViewModels.Requests.StockInOutRequestVm;
import com.megayasa.Backend.ViewModels.Responses.StockInOutResponseVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StockInOutController {
    private final StockInOutService stockInOutService;

    @Autowired
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
        return stockInOutService.findStockInOuts();
    }

    public void deleteStockInOut(String id){
        stockInOutService.deleteStockInOut(id);
    }
}
