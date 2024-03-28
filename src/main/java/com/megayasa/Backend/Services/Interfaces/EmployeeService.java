package com.megayasa.Backend.Services.Interfaces;


import com.megayasa.Backend.Models.Employee;

public interface EmployeeService {
    Employee findById(String employeeId);
}
