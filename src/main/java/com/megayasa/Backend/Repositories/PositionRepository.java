package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {
}
