package com.megayasa.Backend.Controllers;

import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Services.Interfaces.EmployeeService;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findById(String employeeId){
        return employeeService.findById(employeeId);
    }

    public void createEmployee(EmployeeRequestVm employeeRequestVm){
        employeeService.createEmployee(employeeRequestVm);
    }

    public void updateEmployee(String employeeId, EmployeeRequestVm employeeRequestVm){
        employeeService.updateEmployee(employeeId, employeeRequestVm);
    }

    public void deleteEmployee(String employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    public List<EmployeeResponseVm> findAllEmployees(){
        return employeeService.findAllEmployees();
    }
}
