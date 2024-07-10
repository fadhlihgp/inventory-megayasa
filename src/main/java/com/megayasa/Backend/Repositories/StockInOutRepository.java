package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.StockInOut;
import com.megayasa.Backend.ViewModels.Responses.StockInOutDashboardResponseVm;

import java.util.List;
import java.util.Optional;

public interface StockInOutRepository {
    List<StockInOutDashboardResponseVm> stockInOutDashboard();
    int countStockInOutByStatusAndToday(Boolean status);
    int countByNowMonth();
    Optional<StockInOut> findById(String id);
    void delete(StockInOut stockInOut);
    List<StockInOut> findAll();
    void create(StockInOut stockInOut);
    void update(StockInOut stockInOut);
}
