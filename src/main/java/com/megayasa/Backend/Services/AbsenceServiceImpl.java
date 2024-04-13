package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Absence;
import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Repositories.AbsenceRepository;
import com.megayasa.Backend.Services.Interfaces.AbsenceService;
import com.megayasa.Backend.Services.Interfaces.EmployeeService;
import com.megayasa.Backend.ViewModels.Requests.AbsenceRequestVm;
import com.megayasa.Backend.ViewModels.Responses.AbsenceDetailResponseVm;
import com.megayasa.Backend.ViewModels.Responses.AbsenceResponseVm;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;

import java.util.List;
import java.util.UUID;

public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final EmployeeService employeeService;

    @Inject
    public AbsenceServiceImpl(AbsenceRepository absenceRepository, EmployeeService employeeService) {
        this.absenceRepository = absenceRepository;
        this.employeeService = employeeService;
    }

    @Override
    public void createOrUpdateAbsence(String absenceId, AbsenceRequestVm absenceRequestVm) {
        ValidationUtils.validate(absenceRequestVm);
        Employee employee = employeeService.findById(absenceRequestVm.getEmployeeId());
        Absence absence = new Absence();
        if (absenceId != null) {
            absence = absenceRepository.findById(absenceId).orElseThrow(() -> new NotFoundException("Data absensi tidak ditemukan"));
        } else {
            absence.setId(UUID.randomUUID().toString());
        }

        absence.setDate(absenceRequestVm.getDate());
        absence.setNote(absenceRequestVm.getNote());
        absence.setInformation(absenceRequestVm.getInformation());
        absence.setEmployeeId(employee.getId());

        try {
            absenceRepository.create(absence);
            String successMessage = absenceId == null ? "Berhasil menambah data absen karyawan" : "Berhasil memperbarui data asben karyawan";
            InformationDialog.successMessage(successMessage);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void deleteAbsence(String id) {
        Absence absence = absenceRepository.findById(id).orElseThrow(() -> new NotFoundException("Data absen tidak ditemukan"));

        try {
            absenceRepository.delete(absence);
            InformationDialog.deleteSuccess("Berhasil menghapus data absensi karyawan");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public List<AbsenceResponseVm> absenceList() {
        return absenceRepository.absenceList();
    }

    @Override
    public AbsenceDetailResponseVm findAbsenceById(String id) {
        Absence absence = absenceRepository.findById(id).orElseThrow(() -> new NotFoundException("Data absen tidak ditemukan"));
        Employee employee = employeeService.findById(absence.getEmployeeId());
        return new AbsenceDetailResponseVm(absence.getId(), employee.getId(), employee.getFullName(),
                absence.getInformation(), absence.getNote(), absence.getDate());
    }

    @Override
    public List<AbsenceDetailResponseVm> absenceDetailList() {
        List<Absence> absences = absenceRepository.findAll();
        List<EmployeeResponseVm> employees = employeeService.findAllEmployees();

        return absences.stream().map(absence -> new AbsenceDetailResponseVm(absence.getId(), absence.getEmployeeId(),
                employees.stream().filter(e -> e.getId().equals(absence.getEmployeeId())).findFirst().orElse(null).getFullName(),
                absence.getInformation(), absence.getNote(), absence.getDate())).toList();
    }
}
