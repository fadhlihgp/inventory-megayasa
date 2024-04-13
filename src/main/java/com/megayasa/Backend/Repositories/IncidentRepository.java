package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Incident;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IncidentRepository {
    Long countIncidentToday();
    void save(Incident incident);
    void update(Incident incident);
    Optional<Incident> findById(String id);
    List<Incident> findAll();
    void delete(Incident incident);
}
