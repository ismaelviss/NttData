package com.ismaelviss.nttdata.application.service;

import com.ismaelviss.nttdata.application.port.in.AccountServicePort;
import com.ismaelviss.nttdata.application.port.out.AccountPort;
import com.ismaelviss.nttdata.common.UseCase;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;
import java.util.List;

@UseCase
public class AccountService implements AccountServicePort {

    private final AccountPort accountPort;

    public AccountService(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    @Override
    public Account get(String id) throws ApplicationException {
        return accountPort.get(id);
    }

    @Override
    public List<Account> getAll() {
        return accountPort.getAll();
    }

    @Override
    public void update(Account account) throws ApplicationException {
        accountPort.update(account);
    }

    @Override
    public void delete(String id) throws ApplicationException {
        accountPort.delete(id);
    }

    @Override
    public Account add(Account account) {
        return accountPort.add(account);
    }
}
