package com.ismaelviss.nttdata.adapter.out.persistence.mapper;

import com.ismaelviss.nttdata.adapter.out.persistence.entity.ClientEntity;
import com.ismaelviss.nttdata.domain.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {

    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "clientId"),
    })
    public abstract Client toClient(ClientEntity clientEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "accountEntities", ignore = true)
    })
    public abstract ClientEntity toClientEntity(Client client);
}
