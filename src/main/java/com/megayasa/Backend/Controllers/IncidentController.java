package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Incident;
import com.megayasa.Backend.Services.Interfaces.IncidentService;
import com.megayasa.Backend.ViewModels.Requests.IncidentRequestVm;

import java.util.List;

public class IncidentController {
    private final IncidentService incidentService;

    @Inject
    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }


    public void createOrUpdateIncident(String incidentId, IncidentRequestVm incidentRequestVm){
        incidentService.createOrUpdateIncident(incidentId, incidentRequestVm);
    }

    public void deleteIncident(String incidentId){
        incidentService.deleteIncident(incidentId);
    }

    public Incident findIncidentById(String incidentId){
        return incidentService.findIncidentById(incidentId);
    }

    public List<Incident> findAllIncidents(){
        return incidentService.findAllIncidents();
    }
}
