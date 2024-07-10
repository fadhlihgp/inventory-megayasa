package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.StockInOut;
import com.megayasa.Backend.Repositories.QueryRepository;
import com.megayasa.Backend.Repositories.StockInOutRepository;
import com.megayasa.Backend.ViewModels.Responses.StockInOutDashboardResponseVm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    public List<StockInOutDashboardResponseVm> stockInOutDashboard() {
        String query = "WITH recursive dates AS (" +
                "    SELECT LAST_DAY(CURDATE() - INTERVAL 5 MONTH ) AS date " +
                "    UNION ALL" +
                "    SELECT LAST_DAY(date + INTERVAL 1 MONTH) " +
                "    FROM dates " +
                "    WHERE date < LAST_DAY(CURDATE())" +
                ")" +
                "    select d.date," +
                "    SUM(CASE WHEN s.status = 1 THEN 1 ELSE 0 END ) as InStock," +
                "    SUM(CASE WHEN s.status = 0 THEN 1 ELSE 0 END ) as OutStock " +
                "    from dates d " +
                "    left join stock_in_out s on MONTH(s.date) = MONTH(d.date) " +
                "    GROUP BY d.date";
        List<StockInOutDashboardResponseVm> responseVms = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                responseVms.add(new StockInOutDashboardResponseVm(
                        resultSet.getDate(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));
            }
            return responseVms;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countStockInOutByStatusAndToday(Boolean status) {
        try {
            String sql = "select count(s.id) from stock_in_out s where s.status = ? and s.date = CURRENT_DATE";
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
    public int countByNowMonth() {
        String sql = "Select count(*) from stock_in_out where MONTH(date) = MONTH(NOW()) and YEAR(date) = YEAR(NOW())";
        return queryRepository.countWithCustomQuery(sql);
    }

    @Override
    public Optional<StockInOut> findById(String id) {
        return queryRepository.findById(id);
    }

    @Override
    public void delete(StockInOut stockInOut) {
        queryRepository.deleteById(stockInOut.getId());
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
