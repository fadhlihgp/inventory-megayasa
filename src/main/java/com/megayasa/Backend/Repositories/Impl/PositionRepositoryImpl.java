package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Repositories.PositionRepository;
import com.megayasa.Backend.Repositories.QueryRepository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class PositionRepositoryImpl implements PositionRepository {

    private final QueryRepository<Position, String> queryRepository;

    @Inject
    public PositionRepositoryImpl(Connection connection) {
        queryRepository = new QueryRepositoryImpl<>(Position.class, connection);
    }

    @Override
    public void create(Position position) {
        queryRepository.save(position);
    }

    @Override
    public void update(Position position) {
        queryRepository.update(position);
    }

    @Override
    public void delete(Position position) {
        queryRepository.deleteByClass(position);
    }

    @Override
    public List<Position> findAll() {
        return queryRepository.findAll();
    }

    @Override
    public Optional<Position> findById(String id) {
        return queryRepository.findById(id);
    }
}
