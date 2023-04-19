package com.ismaelviss.nttdata.adapter.in.web;

import com.ismaelviss.nttdata.application.port.in.AccountServicePort;
import com.ismaelviss.nttdata.common.WebAdapter;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;
import io.swagger.annotations.Api;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@Validated
@Api(tags = "Account")
@RequestMapping(value = "/v1/cuentas")
public class AccountController {

    private final AccountServicePort accountServicePort;

    public AccountController(AccountServicePort accountServicePort) {
        this.accountServicePort = accountServicePort;
    }

    @RequestMapping(value = "/{accountNumber}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) throws ApplicationException {
        return new ResponseEntity<>(accountServicePort.get(accountNumber), HttpStatus.OK);
    }

    @RequestMapping(
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountServicePort.add(account), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{accountNumber}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable String accountNumber) throws ApplicationException {
        accountServicePort.delete(accountNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
