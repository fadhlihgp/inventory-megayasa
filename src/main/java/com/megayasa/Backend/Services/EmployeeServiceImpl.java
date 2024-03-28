package com.megayasa.Backend.Services;

import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Repositories.EmployeeRepository;
import com.megayasa.Backend.Services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(String employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Karyawan tidak ditemukan"));
    }
}
