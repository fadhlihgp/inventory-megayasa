package com.megayasa.Backend.Services.Interfaces;


import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;

import java.util.List;

public interface EmployeeService {
    Employee findById(String employeeId);
    void createEmployee(EmployeeRequestVm employeeRequestVm);
    void updateEmployee(String employeeId, EmployeeRequestVm employeeRequestVm);
    void deleteEmployee(String employeeId);
    List<EmployeeResponseVm> findAllEmployees();
}
