package com.megayasa.Backend.Controllers;

import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Services.Interfaces.PositionService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PositionController {
    private final PositionService positionService;

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
}
