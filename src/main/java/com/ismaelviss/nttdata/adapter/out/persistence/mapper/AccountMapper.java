package com.ismaelviss.nttdata.adapter.out.persistence.mapper;

import com.ismaelviss.nttdata.adapter.out.persistence.entity.AccountEntity;
import com.ismaelviss.nttdata.adapter.out.persistence.entity.ClientEntity;
import com.ismaelviss.nttdata.domain.Account;
import com.ismaelviss.nttdata.domain.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {

    public static final AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class );

    @Mappings({
            @Mapping(source = "clientEntity.id", target = "clientId")
    })
    public abstract Account toAccount(AccountEntity accountEntity);

    @InheritInverseConfiguration
    public abstract AccountEntity toAccountEntity(Account account);
}
