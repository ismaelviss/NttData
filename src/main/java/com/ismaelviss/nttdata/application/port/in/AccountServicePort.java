package com.ismaelviss.nttdata.application.port.in;

import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;
import com.ismaelviss.nttdata.domain.Client;

import java.util.List;

public interface AccountServicePort {
    Account get(String id) throws ApplicationException;
    List<Account> getAll();

    void update(Account account) throws ApplicationException;
    void delete(String id) throws ApplicationException;
    Account add(Account account);
}
