package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Repositories.EmployeeRepository;
import com.megayasa.Backend.Repositories.QueryRepository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final QueryRepository<Employee, String> queryRepository;

    @Inject
    public EmployeeRepositoryImpl(Connection connection) {
        this.queryRepository = new QueryRepositoryImpl<>(Employee.class, connection);
    }

    @Override
    public Optional<Employee> findById(String employeeId) {
        return queryRepository.findById(employeeId);
    }

    @Override
    public void delete(Employee employee) {
        queryRepository.deleteByClass(employee);
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
}
