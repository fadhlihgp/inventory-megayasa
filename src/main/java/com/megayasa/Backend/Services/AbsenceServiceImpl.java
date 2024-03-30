package com.megayasa.Backend.Services;

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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final EmployeeService employeeService;

    @Autowired
    public AbsenceServiceImpl(AbsenceRepository absenceRepository, EmployeeService employeeService) {
        this.absenceRepository = absenceRepository;
        this.employeeService = employeeService;
    }

    @Override
    public void createOrUpdateAbsence(String absenceId, AbsenceRequestVm absenceRequestVm) {
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
        absence.setEmployee(employee);

        try {
            absenceRepository.save(absence);
            String successMessage = absenceId == null ? "Berhasil menambah data absen karyawan" : "Berhasil memperbarui data asben karyawan";
            InformationDialog.successMessage(successMessage);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void updateAbsence(String absenceId, AbsenceRequestVm absenceRequestVm) {

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
        return new AbsenceDetailResponseVm(absence.getId(), absence.getEmployee().getId(), absence.getEmployee().getFullName(),
                absence.getInformation(), absence.getNote(), absence.getDate());
    }

    @Override
    public List<AbsenceDetailResponseVm> absenceDetailList() {
        List<Absence> absences = absenceRepository.findAll();
        return absences.stream().map(absence -> new AbsenceDetailResponseVm(absence.getId(), absence.getEmployee().getId(), absence.getEmployee().getFullName(),
                absence.getInformation(), absence.getNote(), absence.getDate())).toList();
    }
}
