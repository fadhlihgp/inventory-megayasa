package com.megayasa.Backend.Controllers;

import com.megayasa.Backend.Models.Incident;
import com.megayasa.Backend.Services.Interfaces.IncidentService;
import com.megayasa.Backend.ViewModels.Requests.IncidentRequestVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IncidentController {
    private final IncidentService incidentService;

    @Autowired
    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    public void createIncident(IncidentRequestVm incidentRequestVm){
        incidentService.createIncident(incidentRequestVm);
    }

    public void updateIncident(String incidentId, IncidentRequestVm incidentRequestVm){
        incidentService.updateIncident(incidentId, incidentRequestVm);
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
