package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.Models.Absence;
import com.megayasa.Backend.ViewModels.Requests.AbsenceRequestVm;
import com.megayasa.Backend.ViewModels.Responses.AbsenceDetailResponseVm;
import com.megayasa.Backend.ViewModels.Responses.AbsenceResponseVm;

import java.util.List;

public interface AbsenceService {
    void createOrUpdateAbsence(String absenceId, AbsenceRequestVm absenceRequestVm);
    void deleteAbsence(String id);
    List<AbsenceResponseVm> absenceList();
    AbsenceDetailResponseVm findAbsenceById(String id);
    List<AbsenceDetailResponseVm> absenceDetailList();
}
