package com.ismaelviss.nttdata.adapter.in.web;

import com.ismaelviss.nttdata.application.port.in.AccountServicePort;
import com.ismaelviss.nttdata.application.port.in.ReportServicePort;
import com.ismaelviss.nttdata.common.WebAdapter;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;
import com.ismaelviss.nttdata.domain.ReportMovement;
import io.swagger.annotations.Api;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@WebAdapter
@RestController
@Validated
@Api(tags = "Account")
@RequestMapping(value = "/v1/cuentas")
public class AccountController {

    private final AccountServicePort accountServicePort;
    private final ReportServicePort reportServicePort;

    public AccountController(AccountServicePort accountServicePort, ReportServicePort reportServicePort) {
        this.accountServicePort = accountServicePort;
        this.reportServicePort = reportServicePort;
    }

    @RequestMapping(value = "/{accountNumber}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) throws ApplicationException {
        return new ResponseEntity<>(accountServicePort.get(accountNumber), HttpStatus.OK);
    }

    @RequestMapping(
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAllAccount() throws ApplicationException {
        return new ResponseEntity<>(accountServicePort.getAll(), HttpStatus.OK);
    }

    @RequestMapping(
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Account> addAccount(@RequestBody Account account) throws ApplicationException {
        return new ResponseEntity<>(accountServicePort.add(account), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{accountNumber}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable String accountNumber) throws ApplicationException {
        accountServicePort.delete(accountNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            produces = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) throws ApplicationException {
        accountServicePort.update(account);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/reportes/{accountNumber}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<ReportMovement>> getReports(
            @PathVariable String accountNumber,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(required = false, name = "start_date")
            LocalDate startDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(required = false, name = "end_date")
            LocalDate endDate
    ) throws ApplicationException {
        return new ResponseEntity<>(reportServicePort.getReport(accountNumber, startDate, endDate), HttpStatus.OK);
    }
}
