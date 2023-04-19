package com.ismaelviss.nttdata.adapter.out.persistence.mapper;

import com.ismaelviss.nttdata.adapter.out.persistence.entity.AccountEntity;
import com.ismaelviss.nttdata.adapter.out.persistence.entity.MovementEntity;
import com.ismaelviss.nttdata.domain.Account;
import com.ismaelviss.nttdata.domain.Movement;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MovementMapper {

    public static final MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class );
    public abstract Movement toMovement(MovementEntity movementEntity);

    @InheritInverseConfiguration
    public abstract MovementEntity toMovementEntity(Movement movement);
}
