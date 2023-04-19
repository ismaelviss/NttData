package com.ismaelviss.nttdata.adapter.out.persistence.adapter;

import com.ismaelviss.nttdata.adapter.out.persistence.mapper.MovementMapper;
import com.ismaelviss.nttdata.adapter.out.persistence.repository.MovementRepository;
import com.ismaelviss.nttdata.application.port.out.MovementPort;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Movement;

import java.util.List;

public class MovementPersistenceAdapter implements MovementPort {

    private final MovementRepository movementRepository;

    public MovementPersistenceAdapter(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public Movement get(Long id) throws ApplicationException {
        return movementRepository
                .findById(id)
                .map(MovementMapper.INSTANCE::toMovement)
                .orElseThrow(() -> new ApplicationException("NOT_FOUND_MOVEMENT", "no existen movimientos"));
    }

    @Override
    public List<Movement> getAll() {
        return movementRepository
                .findAll()
                .stream()
                .map(MovementMapper.INSTANCE::toMovement)
                .toList();
    }

    @Override
    public void update(Movement movement) throws ApplicationException {
        var movementEntityOptional = movementRepository.findById(movement.getId());
        if (movementEntityOptional.isPresent()) {
            var movementEntity = movementEntityOptional.get();
            movementEntity.setDate(movement.getDate());
            movementEntity.setMovementType(movement.getMovementType());
            movementEntity.setAmount(movement.getAmount());
            movementEntity.setBalance(movement.getBalance());
            movementRepository.save(movementEntity);
        }
        else {
            throw new ApplicationException("NOT_FOUND_MOVEMENT", "no existen movimientos");
        }
    }

    @Override
    public void delete(Long id) throws ApplicationException {
        var movementEntityOptional = movementRepository.findById(id);
        if (movementEntityOptional.isPresent()) {
            movementRepository.delete(movementEntityOptional.get());
        }
        else {
            throw new ApplicationException("NOT_FOUND_MOVEMENT", "no existen movimientos");
        }
    }

    @Override
    public Movement add(Movement movement) {
        return MovementMapper.INSTANCE.toMovement(movementRepository.save(MovementMapper.INSTANCE.toMovementEntity(movement)));
    }
}
