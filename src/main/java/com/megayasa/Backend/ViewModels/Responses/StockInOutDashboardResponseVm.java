package com.megayasa.Backend.ViewModels.Responses;

import java.util.Date;

public class StockInOutDashboardResponseVm {
    private Date date;
    private int stockIn, stockOut;

    public StockInOutDashboardResponseVm() {
    }

    public StockInOutDashboardResponseVm(Date date, int stockIn, int stockOut) {
        this.date = date;
        this.stockIn = stockIn;
        this.stockOut = stockOut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStockIn() {
        return stockIn;
    }

    public void setStockIn(int stockIn) {
        this.stockIn = stockIn;
    }

    public int getStockOut() {
        return stockOut;
    }

    public void setStockOut(int stockOut) {
        this.stockOut = stockOut;
    }

    @Override
    public String toString() {
        return "StockInOutDashboardResponseVm{" +
                "date=" + date +
                ", stockIn=" + stockIn +
                ", stockOut=" + stockOut +
                '}';
    }
}
