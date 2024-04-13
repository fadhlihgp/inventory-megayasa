package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Services.Interfaces.AbsenceService;
import com.megayasa.Backend.ViewModels.Requests.AbsenceRequestVm;
import com.megayasa.Backend.ViewModels.Responses.AbsenceDetailResponseVm;
import com.megayasa.Backend.ViewModels.Responses.AbsenceResponseVm;

import java.util.List;

public class AbsenceController {
    private final AbsenceService absenceService;

    @Inject
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    public void createOrUpdateAbsence(String absenceId, AbsenceRequestVm absenceRequestVm){
        absenceService.createOrUpdateAbsence(absenceId,absenceRequestVm);
    }

    public void deleteAbsence(String id){
        absenceService.deleteAbsence(id);
    }

    public List<AbsenceResponseVm> absenceList(){
        return absenceService.absenceList();
    }

    AbsenceDetailResponseVm findAbsenceById(String id){
        return absenceService.findAbsenceById(id);
    }

    List<AbsenceDetailResponseVm> absenceDetailList(){
        return absenceService.absenceDetailList();
    }
}
