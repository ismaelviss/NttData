package com.ismaelviss.nttdata.application.service;

import com.ismaelviss.nttdata.application.port.in.MovementServicePort;
import com.ismaelviss.nttdata.application.port.out.AccountPort;
import com.ismaelviss.nttdata.application.port.out.MovementPort;
import com.ismaelviss.nttdata.common.UseCase;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Movement;

import java.time.LocalDateTime;
import java.util.List;

@UseCase
public class MovementService implements MovementServicePort {

    private final MovementPort movementPort;
    private final AccountPort accountPort;

    public MovementService(MovementPort movementPort, AccountPort accountPort) {
        this.movementPort = movementPort;
        this.accountPort = accountPort;
    }

    @Override
    public Movement get(Long id) throws ApplicationException {
        return movementPort.get(id);
    }

    @Override
    public List<Movement> getAll() throws ApplicationException {
        var movements = movementPort.getAll();

        if (movements.isEmpty())
            throw new ApplicationException("NOT_FOUND_MOVEMENT", "no existen movimientos");

        return movements;
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
    public Movement add(Movement movement) throws ApplicationException {
        var account = accountPort.get(movement.getAccountNumber());

        if (account == null)
            throw new ApplicationException("NOT_FOUND_ACCOUNT", "cuenta no existe");

        if (movement.getAmount() == 0)
            throw new ApplicationException("NOT_ZERO", "valor de movimiento no puede ser cero");

        var lastMovement = movementPort.getLast(movement.getAccountNumber());
        Double balance = 0.0;
        if (lastMovement != null)
            balance = lastMovement.getBalance();
        else
            balance = account.getInitialBalance();

        if (balance + movement.getAmount() < 0)
            throw new ApplicationException("BALANCE_NOT_AVAILABLE", "Saldo no disponible");

        movement.setDate(LocalDateTime.now());
        movement.setMovementType(movement.getAmount() > 0? Movement.CREDIT : Movement.DEBIT);
        movement.setBalance(balance + movement.getAmount());

        return movementPort.add(movement);
    }
}
