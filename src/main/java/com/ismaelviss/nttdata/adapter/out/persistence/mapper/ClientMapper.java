package com.ismaelviss.nttdata.adapter.out.persistence.mapper;

import com.ismaelviss.nttdata.adapter.out.persistence.entity.ClientEntity;
import com.ismaelviss.nttdata.domain.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {

    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "clientId"),
    })
    public abstract Client toClient(ClientEntity clientEntity);

    @InheritInverseConfiguration
    public abstract ClientEntity toClientEntity(Client client);
}
