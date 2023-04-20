package com.ismaelviss.nttdata.application.port.out;

import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;
import com.ismaelviss.nttdata.domain.Client;

import java.util.List;

public interface AccountPort {
    Account get(String id) throws ApplicationException;

    List<Account> getAll();

    void update(Account account) throws ApplicationException;

    void delete(String id) throws ApplicationException;

    Account add(Account account) throws ApplicationException;
}
