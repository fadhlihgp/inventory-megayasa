package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Absence;
import com.megayasa.Backend.ViewModels.Responses.AbsenceResponseVm;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AbsenceRepository {
    Optional<Absence> findById(String id);
    Optional<Absence> findByEmployeeAndDate(String employeeId, Date date);
    void create(Absence absence);
    void update(Absence absence);
    void delete(Absence absence);
    List<Absence> findAll();
    List<AbsenceResponseVm> absenceList();
}
