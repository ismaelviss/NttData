package com.ismaelviss.nttdata.application.service;

import com.ismaelviss.nttdata.application.port.out.ClientPort;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientPort clientPort;

    @Test
    void get_success() throws ApplicationException {
        assertNotNull(clientPort);
        when(clientPort.get(1L)).thenReturn(client());
        ClientService clientService = new ClientService(clientPort);
        assertEquals("elvis salvatierra", clientService.get(1L).getName());
    }

    @Test
    void get_error() throws ApplicationException {
        assertNotNull(clientPort);
        when(clientPort.get(Mockito.anyLong())).thenThrow(new ApplicationException("NOT_FOUND_CLIENT", "cliente no existe"));
        ClientService clientService = new ClientService(clientPort);
        ApplicationException exception = assertThrows(ApplicationException.class,() -> clientPort.get(2L));
        assertEquals("NOT_FOUND_CLIENT", exception.getCode());
    }

    private Client client () {
        var client = new Client();
        client.setClientId(1L);
        client.setName("elvis salvatierra");
        return client;
    }
}