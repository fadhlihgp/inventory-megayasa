package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Services.Interfaces.PositionService;

import java.util.List;

public class PositionController {
    private final PositionService positionService;

    @Inject
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    public void createPosition(String positionName) {
        positionService.createPosition(positionName);
    }

    public void updatePosition(String positionId, String positionName){
        positionService.updatePosition(positionId, positionName);
    }

    public void deletePosition(String positionId) {
        positionService.deletePosition(positionId);
    }

    public List<Position> findAllPositions(){
        return positionService.findAllPositions();
    }

    public Position findPositionById(String id) {
        return positionService.findPositionById(id);
    }
}
