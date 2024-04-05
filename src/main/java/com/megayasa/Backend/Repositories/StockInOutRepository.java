package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.StockInOut;

import java.util.List;
import java.util.Optional;

public interface StockInOutRepository {
    int countStockInOutByStatusAndToday(Boolean status);
    Optional<StockInOut> findById(String id);
    void delete(StockInOut stockInOut);
    List<StockInOut> findAll();
    void create(StockInOut stockInOut);
    void update(StockInOut stockInOut);
}
