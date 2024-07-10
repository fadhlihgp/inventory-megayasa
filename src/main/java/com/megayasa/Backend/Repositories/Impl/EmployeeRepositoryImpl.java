package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Repositories.EmployeeRepository;
import com.megayasa.Backend.Repositories.QueryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final QueryRepository<Employee, String> queryRepository;
    private final Connection connection;

    @Inject
    public EmployeeRepositoryImpl(Connection connection, Connection connection1) {
        this.queryRepository = new QueryRepositoryImpl<>(Employee.class, connection);
        this.connection = connection1;
    }

    @Override
    public Optional<Employee> findById(String employeeId) {
        return queryRepository.findById(employeeId);
    }

    @Override
    public Optional<Employee> findByIdentity(String identity) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("identityNumber", identity);
        return queryRepository.findOneByFilter(filters, "AND");
    }

    @Override
    public int countAllEmployee() {
        return queryRepository.count();
    }

    @Override
    public void delete(Employee employee) {
        queryRepository.deleteById(employee.getId());
    }

    @Override
    public List<Employee> findAll() {
        return queryRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
        queryRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        queryRepository.update(employee);
    }

    @Override
    public void deletePresenceWhereEmployee(String employeeId) {
        String sql = "DELETE FROM presence where employee_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employeeId);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccountWhereEmployee(String employeeId) {
        String sql = "DELETE FROM account where employee_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employeeId);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
