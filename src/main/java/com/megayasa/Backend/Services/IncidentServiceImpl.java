package com.megayasa.Backend.Services;

import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Incident;
import com.megayasa.Backend.Repositories.IncidentRepository;
import com.megayasa.Backend.Services.Interfaces.IncidentService;
import com.megayasa.Backend.Utils.PhotoService;
import com.megayasa.Backend.ViewModels.Requests.IncidentRequestVm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IncidentServiceImpl implements IncidentService {
    private final IncidentRepository incidentRepository;
    private final PhotoService uploadPhoto = new PhotoService();

    @Autowired
    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public void createIncident(IncidentRequestVm incidentRequestVm) {
        String formattedDate = new SimpleDateFormat("ddMMyy").format(new Date());
        String id = "IN-" + formattedDate + String.format("%02d", incidentRepository.countIncidentToday() + 1);
        String imageUrl = uploadPhoto.UploadPhoto(incidentRequestVm.getPictureUrl());

        Incident incident = new Incident(id, incidentRequestVm.getDate(),
                imageUrl, incidentRequestVm.getTitle(), incidentRequestVm.getDescription());

        try {
            incidentRepository.save(incident);
            InformationDialog.successMessage("Berhasil menambah data insiden");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void updateIncident(String incidentId, IncidentRequestVm incidentRequestVm) {
        Incident findIncident = findIncidentById(incidentId);

        try {
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
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void deleteIncident(String incidentId) {
        Incident incident = findIncidentById(incidentId);

        try {
            incidentRepository.delete(incident);
            InformationDialog.deleteSuccess("Berhasil menghapus data insiden");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
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
