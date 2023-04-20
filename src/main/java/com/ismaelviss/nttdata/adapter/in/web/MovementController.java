package com.ismaelviss.nttdata.adapter.in.web;

import com.ismaelviss.nttdata.application.port.in.MovementServicePort;
import com.ismaelviss.nttdata.common.WebAdapter;
import com.ismaelviss.nttdata.domain.Movement;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public ResponseEntity<List<Movement>> getMovements() {
        return new ResponseEntity<>(movementServicePort.getAll(), HttpStatus.OK);
    }


}
