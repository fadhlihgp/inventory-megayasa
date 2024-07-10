package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Services.Interfaces.EmployeeService;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;

import java.util.List;

public class EmployeeController {
    private final EmployeeService employeeService;

    @Inject
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findById(String employeeId){
        return employeeService.findById(employeeId);
    }

    public void createOrUpdateEmployee(String employeeId, EmployeeRequestVm employeeRequestVm){
        employeeService.createOrUpdateEmployee(employeeId, employeeRequestVm);
    }

    public void deleteEmployee(String employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    public List<EmployeeResponseVm> findAllEmployees(){
        return employeeService.findAllEmployees();
    }
}
