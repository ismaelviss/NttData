package com.ismaelviss.nttdata.application.service;

import com.ismaelviss.nttdata.application.port.in.ClientServicePort;
import com.ismaelviss.nttdata.application.port.out.ClientPort;
import com.ismaelviss.nttdata.common.UseCase;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Client;

import java.util.List;

@UseCase
public class ClientService implements ClientServicePort {

    private final ClientPort clientPort;

    public ClientService(ClientPort clientPort) {
        this.clientPort = clientPort;
    }
    @Override
    public Client get(Long id) throws ApplicationException {
        return clientPort.get(id);
    }

    @Override
    public List<Client> getAll() throws ApplicationException {
        var clients = clientPort.getAll();
        if (clients.isEmpty())
            throw new ApplicationException("NOT_FOUND_CLIENT", "cliente no existe");

        return clients;
    }

    @Override
    public void update(Client client) throws ApplicationException {
        clientPort.update(client);
    }

    @Override
    public void delete(Long id) throws ApplicationException {
        clientPort.delete(id);
    }

    @Override
    public Client add(Client client) {
        return clientPort.add(client);
    }
}
