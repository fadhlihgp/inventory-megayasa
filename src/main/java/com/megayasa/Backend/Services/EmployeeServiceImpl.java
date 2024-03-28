package com.megayasa.Backend.Services;

import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Exceptions.WarningException;
import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Repositories.EmployeeRepository;
import com.megayasa.Backend.Services.Interfaces.EmployeeService;
import com.megayasa.Backend.Services.Interfaces.PositionService;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PositionService positionService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionService positionService) {
        this.employeeRepository = employeeRepository;
        this.positionService = positionService;
    }

    @Override
    public Employee findById(String employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Karyawan tidak ditemukan"));
    }

    @Override
    public void createEmployee(EmployeeRequestVm employeeRequestVm) {
        ValidationUtils.validate(employeeRequestVm);
        Employee findId = employeeRepository.findById(employeeRequestVm.getEmployeeId()).orElse(null);
        if (findId != null) throw new WarningException("Id karyawan sudah tersedia!");

        Employee employee = new Employee(employeeRequestVm.getEmployeeId(), employeeRequestVm.getFullName(), employeeRequestVm.getBirthDate(),
                employeeRequestVm.getAddress(), employeeRequestVm.getGender(), employeeRequestVm.getPhoneNumber(),
                employeeRequestVm.getIdentityNumber(), (employeeRequestVm.getIsActive() == null || employeeRequestVm.getIsActive()),
                positionService.findPositionById(employeeRequestVm.getPositionId()), null);
        try {
            employeeRepository.save(employee);
            InformationDialog.successMessage("Berhasil menambah data karyawan");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }

    }

    @Override
    public void updateEmployee(String employeeId, EmployeeRequestVm employeeRequestVm) {
        ValidationUtils.validate(employeeRequestVm);
        Employee employee = findById(employeeId);
        employee.setFullName(employeeRequestVm.getFullName());
        employee.setActive(employeeRequestVm.getIsActive());
        employee.setAddress(employeeRequestVm.getAddress());
        employee.setGender(employeeRequestVm.getGender());
        employee.setBirthDate(employeeRequestVm.getBirthDate());
        employee.setPosition(positionService.findPositionById(employeeRequestVm.getPositionId()));
        employee.setPhoneNumber(employeeRequestVm.getPhoneNumber());
        employee.setIdentityNumber(employeeRequestVm.getIdentityNumber());

        try {
            employeeRepository.save(employee);
            InformationDialog.successMessage("Berhasil mengubah data karyawan");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(String employeeId) {
        Employee employee = findById(employeeId);

        try {
            employeeRepository.delete(employee);
            InformationDialog.deleteSuccess("Berhasil menghapus data karyawan");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public List<EmployeeResponseVm> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(e -> {
            EmployeeResponseVm responseVm = new EmployeeResponseVm();
            responseVm.setId(e.getId());
            responseVm.setFullName(e.getFullName());
            responseVm.setIdentityNumber(e.getIdentityNumber());
            responseVm.setPhoneNumber(e.getPhoneNumber());
            responseVm.setPositionId(e.getPosition().getId());
            responseVm.setPosition(e.getPosition().getName());
            responseVm.setActive(e.isActive());
            responseVm.setGender(e.getGender());
            responseVm.setBirthDate(e.getBirthDate());
            responseVm.setAddress(e.getAddress());
            return responseVm;
        }).toList();
    }
}
