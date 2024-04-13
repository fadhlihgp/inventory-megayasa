package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Incident;
import com.megayasa.Backend.Repositories.IncidentRepository;
import com.megayasa.Backend.Repositories.QueryRepository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class IncidentRepositoryImpl implements IncidentRepository {
    private final QueryRepository<Incident, String> queryRepository;

    @Inject
    public IncidentRepositoryImpl(Connection connection) {
        queryRepository = new QueryRepositoryImpl<>(Incident.class, connection);
    }

    @Override
    public Long countIncidentToday() {
        return 1L;
    }

    @Override
    public void save(Incident incident) {
        queryRepository.save(incident);
    }

    @Override
    public void update(Incident incident) {
        queryRepository.update(incident);
    }

    @Override
    public Optional<Incident> findById(String id) {
        return queryRepository.findById(id);
    }

    @Override
    public List<Incident> findAll() {
        return queryRepository.findAll();
    }

    @Override
    public void delete(Incident incident) {
        queryRepository.deleteByClass(incident);
    }
}
