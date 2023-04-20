package com.ismaelviss.nttdata.adapter.in.web;

import com.ismaelviss.nttdata.adapter.in.web.itfc.ClientApi;
import com.ismaelviss.nttdata.application.port.in.ClientServicePort;
import com.ismaelviss.nttdata.common.WebAdapter;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Client;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@Validated
public class ClientController implements ClientApi {
    private final ClientServicePort clientServicePort;

    public ClientController(ClientServicePort clientServicePort) {
        this.clientServicePort = clientServicePort;
    }

    @Override
    public ResponseEntity<Client> getClient(Long id) throws ApplicationException {
        return new ResponseEntity<>(clientServicePort.get(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientServicePort.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateClient(Client client) throws ApplicationException {
        clientServicePort.update(client);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteClient(Long id) throws ApplicationException {
        clientServicePort.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Client> addClient(Client client) {
        return new ResponseEntity<>(clientServicePort.add(client), HttpStatus.CREATED);
    }
}
