package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Repositories.PositionRepository;
import com.megayasa.Backend.Services.Interfaces.PositionService;
import java.util.List;
import java.util.UUID;

public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Inject
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void createPosition(String positionName) {
        Position position = new Position(UUID.randomUUID().toString(), positionName);
        TransactionUtil.performTransaction(() -> {
            positionRepository.create(position);
            InformationDialog.successMessage("Berhasil menambah data jabatan");
        });

    }

    @Override
    public void updatePosition(String positionId, String positionName) {
        Position position = positionRepository.findById(positionId).orElseThrow(() -> new NotFoundException("Data jabatan tidak ditemukan"));
        TransactionUtil.performTransaction(() -> {
            position.setName(positionName);
            positionRepository.update(position);
            InformationDialog.successMessage("Berhasil memperbarui data jabatan");
        });
    }

    @Override
    public void deletePosition(String positionId) {
        Position position = positionRepository.findById(positionId).orElseThrow(() -> new NotFoundException("Data jabatan tidak ditemukan"));
        TransactionUtil.performTransaction(() -> {
            positionRepository.delete(position);
        });
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
