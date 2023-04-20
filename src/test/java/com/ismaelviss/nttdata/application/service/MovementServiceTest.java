package com.ismaelviss.nttdata.application.service;

import com.ismaelviss.nttdata.application.port.out.AccountPort;
import com.ismaelviss.nttdata.application.port.out.MovementPort;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;
import com.ismaelviss.nttdata.domain.Movement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovementServiceTest {

    @Mock
    private MovementPort movementPort;

    @Mock
    private AccountPort accountPort;

    String accountNumber = "1";

    @Test
    void add_success() throws ApplicationException {
        assertNotNull(movementPort);
        assertNotNull(accountPort);

        when(accountPort.get(accountNumber)).thenReturn(account());
        when(movementPort.getLast(accountNumber)).thenReturn(null);
        when(movementPort.add(Mockito.any(Movement.class))).thenReturn(movement(1L));

        MovementService movementService = new MovementService(movementPort, accountPort);
        var movement = new Movement();
        movement.setAmount(100.0);
        movement.setAccountNumber(accountNumber);
        var movementResponse = movementService.add(movement);

        assertEquals(100.0, movementResponse.getAmount());
        assertEquals(1100.0, movementResponse.getBalance());
        assertEquals(Movement.CREDIT, movementResponse.getMovementType());
        assertEquals(accountNumber, movementResponse.getAccountNumber());
    }

    @Test
    void add_exception_1() throws ApplicationException {
        assertNotNull(movementPort);
        assertNotNull(accountPort);

        when(accountPort.get(accountNumber)).thenReturn(null);
        MovementService movementService = new MovementService(movementPort, accountPort);

        ApplicationException exception = assertThrows(ApplicationException.class,() -> movementService.add(movement(1L)));
        assertEquals("NOT_FOUND_ACCOUNT", exception.getCode());
    }

    @Test
    void add_exception_2() throws ApplicationException {
        assertNotNull(movementPort);
        assertNotNull(accountPort);

        when(accountPort.get(accountNumber)).thenReturn(account());

        MovementService movementService = new MovementService(movementPort, accountPort);
        var movement = new Movement();
        movement.setAmount(0.0);
        movement.setAccountNumber(accountNumber);

        ApplicationException exception = assertThrows(ApplicationException.class,() -> movementService.add(movement));
        assertEquals("NOT_ZERO", exception.getCode());
    }

    @Test
    void add_exception_3() throws ApplicationException {
        assertNotNull(movementPort);
        assertNotNull(accountPort);

        when(accountPort.get(accountNumber)).thenReturn(account());
        when(movementPort.getLast(accountNumber)).thenReturn(null);

        MovementService movementService = new MovementService(movementPort, accountPort);
        var movement = new Movement();
        movement.setAmount(-2000.0);
        movement.setAccountNumber(accountNumber);

        ApplicationException exception = assertThrows(ApplicationException.class,() -> movementService.add(movement));
        assertEquals("BALANCE_NOT_AVAILABLE", exception.getCode());

    }

    private Account account() {
        var account = new Account();
        account.setInitialBalance(1000.0);
        return account;
    }

    private Movement movement(Long id) {
        var movement = new Movement();
        movement.setMovementType(Movement.CREDIT);
        movement.setDate(LocalDateTime.of(2023, 4, 19, 17, 17, 17, 777777));
        movement.setAmount(100.0);
        movement.setBalance(1100.0);
        movement.setId(id);
        movement.setAccountNumber(accountNumber);
        return movement;
    }
}