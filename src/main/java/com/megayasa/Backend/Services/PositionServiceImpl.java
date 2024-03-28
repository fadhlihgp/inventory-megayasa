package com.megayasa.Backend.Services;

import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Repositories.PositionRepository;
import com.megayasa.Backend.Services.Interfaces.PositionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void createPosition(String positionName) {
        Position position = new Position(UUID.randomUUID().toString(), positionName);
        try {
            positionRepository.save(position);
            InformationDialog.successMessage("Berhasil menambah data jabatan");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }

    }

    @Override
    public void updatePosition(String positionId, String positionName) {
        Position position = positionRepository.findById(positionId).orElseThrow(() -> new NotFoundException("Data jabatan tidak ditemukan"));
        try {
            position.setName(positionName);
            positionRepository.save(position);
            InformationDialog.successMessage("Berhasil memperbarui data jabatan");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public void deletePosition(String positionId) {
        Position position = positionRepository.findById(positionId).orElseThrow(() -> new NotFoundException("Data jabatan tidak ditemukan"));
        try {
            positionRepository.delete(position);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public List<Position> findAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position findPositionById(String positionId) {
        return positionRepository.findById(positionId).orElseThrow(() -> new NotFoundException("Jabatan tidak ditemukan"));
    }
}
