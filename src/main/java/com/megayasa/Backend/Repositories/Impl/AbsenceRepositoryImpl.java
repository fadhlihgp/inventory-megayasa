package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Absence;
import com.megayasa.Backend.Repositories.AbsenceRepository;
import com.megayasa.Backend.Repositories.QueryRepository;
import com.megayasa.Backend.ViewModels.Responses.AbsenceResponseVm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class AbsenceRepositoryImpl implements AbsenceRepository {
    private final Connection connection;
    private final QueryRepository<Absence, String> queryRepository;

    @Inject
    public AbsenceRepositoryImpl(Connection connection1, Connection connection) {
        this.connection = connection1;
        queryRepository = new QueryRepositoryImpl<>(Absence.class, connection);
    }

    @Override
    public Optional<Absence> findById(String id) {
        return queryRepository.findById(id);
    }

    @Override
    public Optional<Absence> findByEmployeeAndDate(String employeeId, Date date) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("employeeId", employeeId);
        filters.put("date", date);
        return queryRepository.findOneByFilter(filters, "AND");
    }

    @Override
    public void create(Absence absence) {
        queryRepository.save(absence);
    }

    @Override
    public void update(Absence absence) {
        queryRepository.update(absence);
    }

    @Override
    public void delete(Absence absence) {
        queryRepository.deleteById(absence.getId());
    }

    @Override
    public List<Absence> findAll() {
        return queryRepository.findAll();
    }

    @Override
    public List<AbsenceResponseVm> absenceList() {
        String query = "SELECT e.id as employee_id, e.name, " +
                "IFNULL(SUM(CASE WHEN a.information = 'Cuti' THEN 1 ELSE 0 END), 0) AS Cuti, " +
                "IFNULL(SUM(CASE WHEN a.information = 'Alpa' THEN 1 ELSE 0 END), 0) AS Alpa, " +
                "IFNULL(SUM(CASE WHEN a.information = 'Sakit' THEN 1 ELSE 0 END), 0) AS Sakit, " +
                "IFNULL(SUM(CASE WHEN a.information = 'Izin' THEN 1 ELSE 0 END), 0) AS Izin " +
                "FROM employee e " +
                "LEFT JOIN absence a ON e.id = a.employee_id " +
                "GROUP BY e.id";
        ResultSet resultSet = null;
        List<AbsenceResponseVm> results = new ArrayList<>();
        try {
            resultSet = connection.prepareStatement(query).executeQuery(query);
            while (resultSet.next()){
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                int leave = resultSet.getInt("Cuti");
                int alpha = resultSet.getInt("Alpa");
                int sick = resultSet.getInt("Sakit");
                int permission = resultSet.getInt("Izin");
                results.add(new AbsenceResponseVm(employeeId, name, leave, alpha, sick, permission));
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return results;
    }
}
