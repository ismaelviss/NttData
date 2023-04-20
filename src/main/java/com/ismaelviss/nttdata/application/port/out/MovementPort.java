package com.ismaelviss.nttdata.application.port.out;

import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Movement;

import java.util.List;

public interface MovementPort {

    Movement get(Long id) throws ApplicationException;

    List<Movement> getAll();

    void update(Movement movement) throws ApplicationException;

    void delete(Long id) throws ApplicationException;

    Movement add(Movement movement);
}
