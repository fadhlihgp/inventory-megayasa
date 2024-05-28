package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Exceptions.WarningException;
import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Repositories.EmployeeRepository;
import com.megayasa.Backend.Services.Interfaces.EmployeeService;
import com.megayasa.Backend.Services.Interfaces.PositionService;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PositionService positionService;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionService positionService) {
        this.employeeRepository = employeeRepository;
        this.positionService = positionService;
    }

    @Override
    public Employee findById(String employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Karyawan tidak ditemukan"));
    }

    private void createEmployee(EmployeeRequestVm employeeRequestVm) {
        ValidationUtils.validate(employeeRequestVm);
        Employee findId = employeeRepository.findById(employeeRequestVm.getEmployeeId()).orElse(null);
        if (findId != null) throw new WarningException("Id karyawan sudah tersedia!");

        Employee findByIdentity = employeeRepository.findByIdentity(employeeRequestVm.getIdentityNumber()).orElse(null);
        if (findByIdentity != null) throw new WarningException("Nomor identitas/KTP karyawan sudah tersedia!");

        Employee employee = new Employee(employeeRequestVm.getEmployeeId(), employeeRequestVm.getFullName(), employeeRequestVm.getBirthDate(),
                employeeRequestVm.getAddress(), employeeRequestVm.getGender(), employeeRequestVm.getPhoneNumber(),
                employeeRequestVm.getIdentityNumber(), (employeeRequestVm.getIsActive() == null || employeeRequestVm.getIsActive()),
                positionService.findPositionById(employeeRequestVm.getPositionId()).getId());

        TransactionUtil.performTransaction(() -> {
            employeeRepository.create(employee);
            InformationDialog.successMessage("Berhasil menambah data karyawan");
        });

    }

    private void updateEmployee(String employeeId, EmployeeRequestVm employeeRequestVm) {
        ValidationUtils.validate(employeeRequestVm);
        Employee employee = findById(employeeId);
        employee.setFullName(employeeRequestVm.getFullName());
        employee.setActive(employeeRequestVm.getIsActive() == null || employeeRequestVm.getIsActive());
        employee.setAddress(employeeRequestVm.getAddress());
        employee.setGender(employeeRequestVm.getGender());
        employee.setBirthDate(employeeRequestVm.getBirthDate());
        employee.setPositionId(positionService.findPositionById(employeeRequestVm.getPositionId()).getId());
        employee.setPhoneNumber(employeeRequestVm.getPhoneNumber());
        employee.setIdentityNumber(employeeRequestVm.getIdentityNumber());

        TransactionUtil.performTransaction(() -> {
            employeeRepository.update(employee);
            InformationDialog.successMessage("Berhasil memperbarui data karyawan");
        });
    }

    @Override
    public void deleteEmployee(String employeeId) {
        Employee employee = findById(employeeId);

        TransactionUtil.performTransaction(() -> {
            employeeRepository.deletePresenceWhereEmployee(employeeId);
            employeeRepository.delete(employee);
            InformationDialog.deleteSuccess("Berhasil menghapus data karyawan");
        });
    }

    @Override
    public void createOrUpdateEmployee(String employeeId, EmployeeRequestVm employeeRequest) {
        if (employeeId == null) {
            createEmployee(employeeRequest);
        } else {
            updateEmployee(employeeId, employeeRequest);
        }
    }

    @Override
    public List<EmployeeResponseVm> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<Position> positions = positionService.findAllPositions();

        return employees.stream().map(e -> {
            EmployeeResponseVm responseVm = new EmployeeResponseVm();
            Position result = positions.stream().filter(p -> p.getId().equals(e.getPositionId()))
                    .findFirst().orElse(null);

            responseVm.setId(e.getId());
            responseVm.setFullName(e.getFullName());
            responseVm.setIdentityNumber(e.getIdentityNumber());
            responseVm.setPhoneNumber(e.getPhoneNumber());
            responseVm.setPositionId(e.getPositionId());
            responseVm.setPosition(result.getName());
            responseVm.setActive(e.isActive());
            responseVm.setGender(e.getGender());
            responseVm.setBirthDate(e.getBirthDate());
            responseVm.setAddress(e.getAddress());
            return responseVm;
        }).toList();
    }
}
