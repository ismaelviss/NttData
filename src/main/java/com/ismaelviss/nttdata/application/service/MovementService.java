package com.ismaelviss.nttdata.application.service;

import com.ismaelviss.nttdata.application.port.in.MovementServicePort;
import com.ismaelviss.nttdata.application.port.out.MovementPort;
import com.ismaelviss.nttdata.common.UseCase;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Movement;

import java.util.List;

@UseCase
public class MovementService implements MovementServicePort {

    private final MovementPort movementPort;

    public MovementService(MovementPort movementPort) {
        this.movementPort = movementPort;
    }

    @Override
    public Movement get(Long id) throws ApplicationException {
        return movementPort.get(id);
    }

    @Override
    public List<Movement> getAll() {
        return movementPort.getAll();
    }

    @Override
    public void update(Movement movement) throws ApplicationException {
        movementPort.update(movement);
    }

    @Override
    public void delete(Long id) throws ApplicationException {
        movementPort.delete(id);
    }

    @Override
    public Movement add(Movement movement) {
        return movementPort.add(movement);
    }
}
