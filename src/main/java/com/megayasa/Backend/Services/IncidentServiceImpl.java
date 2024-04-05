package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Incident;
import com.megayasa.Backend.Repositories.IncidentRepository;
import com.megayasa.Backend.Services.Interfaces.IncidentService;
import com.megayasa.Backend.Utils.PhotoService;
import com.megayasa.Backend.ViewModels.Requests.IncidentRequestVm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class IncidentServiceImpl implements IncidentService {
    private final IncidentRepository incidentRepository;
    private final PhotoService uploadPhoto = new PhotoService();

    @Inject
    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    private void createIncident(IncidentRequestVm incidentRequestVm) {
        String formattedDate = new SimpleDateFormat("ddMMyy").format(new Date());
        String id = "IN-" + formattedDate + String.format("%02d", incidentRepository.countIncidentToday() + 1);
        String imageUrl = uploadPhoto.UploadPhoto(incidentRequestVm.getPictureUrl());

        Incident incident = new Incident(id, incidentRequestVm.getDate(),
                imageUrl, incidentRequestVm.getTitle(), incidentRequestVm.getDescription());

        TransactionUtil.performTransaction(() -> {
            incidentRepository.save(incident);
            InformationDialog.successMessage("Berhasil menambah data insiden");
        });
    }

    private void updateIncident(String incidentId, IncidentRequestVm incidentRequestVm) {
        Incident findIncident = findIncidentById(incidentId);

        TransactionUtil.performTransaction(() -> {
            if (incidentRequestVm.getPictureUrl() != null) {
                if (findIncident.getPictureUrl() != null) {
                    uploadPhoto.deletePhoto(findIncident.getPictureUrl());
                }
                String upload = uploadPhoto.UploadPhoto(incidentRequestVm.getPictureUrl());
                findIncident.setPictureUrl(upload);
            }

            findIncident.setDate(incidentRequestVm.getDate());
            findIncident.setTitle(incidentRequestVm.getTitle());
            findIncident.setDescription(incidentRequestVm.getDescription());
            InformationDialog.successMessage("Berhasil memperbarui data insiden");
        });
    }

    @Override
    public void createOrUpdateIncident(String incidentId, IncidentRequestVm incidentRequestVm) {
        if (incidentId == null) {
            createIncident(incidentRequestVm);
        } else {
            updateIncident(incidentId, incidentRequestVm);
        }
    }

    @Override
    public void deleteIncident(String incidentId) {
        Incident incident = findIncidentById(incidentId);

        TransactionUtil.performTransaction(() -> {
            incidentRepository.delete(incident);
            InformationDialog.deleteSuccess("Berhasil menghapus data insiden");
        });
    }

    @Override
    public Incident findIncidentById(String incidentId) {
        return incidentRepository.findById(incidentId)
                .orElseThrow(() -> new NotFoundException("Id insiden tidak ditemukan"));
    }

    @Override
    public List<Incident> findAllIncidents() {
        return incidentRepository.findAll();
    }
}
