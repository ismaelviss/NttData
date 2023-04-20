package com.ismaelviss.nttdata.application.service;

import com.ismaelviss.nttdata.application.port.in.AccountServicePort;
import com.ismaelviss.nttdata.application.port.in.ReportServicePort;
import com.ismaelviss.nttdata.application.port.out.AccountPort;
import com.ismaelviss.nttdata.application.port.out.ClientPort;
import com.ismaelviss.nttdata.application.port.out.MovementPort;
import com.ismaelviss.nttdata.common.UseCase;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;
import com.ismaelviss.nttdata.domain.Movement;
import com.ismaelviss.nttdata.domain.ReportMovement;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@UseCase
public class AccountService implements AccountServicePort, ReportServicePort {

    private final AccountPort accountPort;
    private final ClientPort clientPort;
    private final MovementPort movementPort;

    public AccountService(AccountPort accountPort, ClientPort clientPort, MovementPort movementPort) {
        this.accountPort = accountPort;
        this.clientPort = clientPort;
        this.movementPort = movementPort;
    }

    @Override
    public Account get(String id) throws ApplicationException {
        return accountPort.get(id);
    }

    @Override
    public List<Account> getAll() throws ApplicationException {
        var accounts = accountPort.getAll();
        if (accounts.isEmpty())
            throw new ApplicationException("NOT_FOUND_ACCOUNT", "cuenta no existe");

        return accounts;
    }

    @Override
    public void update(Account account) throws ApplicationException {
        if (clientPort.get(account.getClientId()) == null)
            throw new ApplicationException("NOT_FOUND_CLIENT", "cliente no existe");

        accountPort.update(account);
    }

    @Override
    public void delete(String id) throws ApplicationException {
        accountPort.delete(id);
    }

    @Override
    public Account add(Account account) throws ApplicationException {

        if (clientPort.get(account.getClientId()) == null)
            throw new ApplicationException("NOT_FOUND_CLIENT", "cliente no existe");

        return accountPort.add(account);
    }

    @Override
    public List<ReportMovement> getReport(String accountNumber, LocalDate startDate, LocalDate endDate) throws ApplicationException {
        var account = accountPort.get(accountNumber);
        if (account == null)
            throw new ApplicationException("NOT_FOUND_ACCOUNT", "cuenta no existe");

        var client = clientPort.get(account.getClientId());
        if (client == null)
            throw new ApplicationException("NOT_FOUND_CLIENT", "cliente no existe");

        List<Movement> movements = movementPort.getAllMovementAccount(accountNumber, startDate.atTime(0,0,0), endDate.atTime(23, 59, 59));

        if (movements.isEmpty())
            throw new ApplicationException("NOT_FOUND_MOVEMENT", "no existen movimientos");

        return movements
                .stream()
                .sorted(Comparator.comparing(Movement::getDate))
                .map(movement -> new ReportMovement(movement.getDate(), client.getName(), account.getAccountNumber(), account.getAccountType(), account.getInitialBalance(), account.getState(), movement.getAmount(), movement.getBalance()))
                .toList();
    }
}
