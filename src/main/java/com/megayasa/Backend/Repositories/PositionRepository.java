package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Position;

import java.util.List;
import java.util.Optional;

public interface PositionRepository {
    void create(Position position);

    void update(Position position);

    void delete(Position position);

    List<Position> findAll();

    Optional<Position> findById(String id);
}
