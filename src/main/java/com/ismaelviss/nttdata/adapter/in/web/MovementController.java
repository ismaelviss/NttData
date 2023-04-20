package com.ismaelviss.nttdata.adapter.in.web;

import com.ismaelviss.nttdata.application.port.in.MovementServicePort;
import com.ismaelviss.nttdata.common.WebAdapter;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;
import com.ismaelviss.nttdata.domain.Movement;
import io.swagger.annotations.Api;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@WebAdapter
@Api(tags = "Movement")
@RestController
@Validated
@RequestMapping(value = "/v1/movimientos")
public class MovementController {

    private final MovementServicePort movementServicePort;

    public MovementController(MovementServicePort movementServicePort) {
        this.movementServicePort = movementServicePort;
    }

    public ResponseEntity<List<Movement>> getMovements() throws ApplicationException {
        return new ResponseEntity<>(movementServicePort.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Movement> getMovement(@PathVariable Long id) throws ApplicationException {
        return new ResponseEntity<>(movementServicePort.get(id), HttpStatus.OK);
    }

    @RequestMapping(
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<Movement>> getAllMovement() throws ApplicationException {
        return new ResponseEntity<>(movementServicePort.getAll(), HttpStatus.OK);
    }

    @RequestMapping(
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Movement> addMovement(@RequestBody Movement movement) throws ApplicationException {
        return new ResponseEntity<>(movementServicePort.add(movement), HttpStatus.CREATED);
    }
}
