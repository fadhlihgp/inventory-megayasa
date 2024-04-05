package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.StockInOut;
import com.megayasa.Backend.Repositories.QueryRepository;
import com.megayasa.Backend.Repositories.StockInOutRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class StockInOutRepositoryImpl implements StockInOutRepository {
    private final Connection connection;
    private final QueryRepository<StockInOut, String> queryRepository;

    @Inject
    public StockInOutRepositoryImpl(Connection connection) {
        this.connection = connection;
        queryRepository = new QueryRepositoryImpl<>(StockInOut.class, connection);
    }

    @Override
    public int countStockInOutByStatusAndToday(Boolean status) {
        try {
            String sql = "select count(s) from stock_in_out s where s.status = ? and s.date = CURRENT_DATE";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, status);
            ResultSet rs = preparedStatement.executeQuery();
            int result = 0;
            if (rs.next()) {
                result = rs.getInt(1);
            }
            preparedStatement.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<StockInOut> findById(String id) {
        return queryRepository.findById(id);
    }

    @Override
    public void delete(StockInOut stockInOut) {
        queryRepository.deleteByClass(stockInOut);
    }

    @Override
    public List<StockInOut> findAll() {
        return queryRepository.findAll();
    }

    @Override
    public void create(StockInOut stockInOut) {
        queryRepository.save(stockInOut);
    }

    @Override
    public void update(StockInOut stockInOut) {
        queryRepository.update(stockInOut);
    }
}
