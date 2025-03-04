package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findById(String employeeId);
    Optional<Employee> findByIdentity(String identity);
    int countAllEmployee();
    void delete(Employee employee);
    List<Employee> findAll();
    void create(Employee employee);
    void update(Employee employee);
    void deletePresenceWhereEmployee(String employeeId);
    void deleteAccountWhereEmployee(String employeeId);
}
