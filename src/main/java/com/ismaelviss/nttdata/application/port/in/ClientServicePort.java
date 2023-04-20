package com.ismaelviss.nttdata.application.port.in;

import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Client;

import java.util.List;

public interface ClientServicePort {

    Client get(Long id) throws ApplicationException;
    List<Client> getAll() throws ApplicationException;

    void update(Client client) throws ApplicationException;
    void delete(Long id) throws ApplicationException;
    Client add(Client client);
}
