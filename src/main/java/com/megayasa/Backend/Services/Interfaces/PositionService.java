package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.Models.Position;

import java.util.List;

public interface PositionService {
    void createPosition(String positionName);
    void updatePosition(String positionId, String positionName);
    void deletePosition(String positionId);
    List<Position> findAllPositions();
}
