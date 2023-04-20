package com.ismaelviss.nttdata.application.port.in;

import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Movement;

import java.util.List;

public interface MovementServicePort {

    Movement get(Long id) throws ApplicationException;
    List<Movement> getAll() throws ApplicationException;

    void update(Movement movement) throws ApplicationException;
    void delete(Long id) throws ApplicationException;
    Movement add(Movement movement) throws ApplicationException;
}
