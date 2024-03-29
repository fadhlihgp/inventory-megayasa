package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.Models.Incident;
import com.megayasa.Backend.ViewModels.Requests.IncidentRequestVm;

import java.util.List;

public interface IncidentService {
    void createIncident(IncidentRequestVm incidentRequestVm);
    void updateIncident(String incidentId, IncidentRequestVm incidentRequestVm);
    void deleteIncident(String incidentId);
    Incident findIncidentById(String incidentId);
    List<Incident> findAllIncidents();
}
