package com.ismaelviss.nttdata.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class ClientEntity extends PersonEntity {

    private String password;
    private Boolean state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountNumber")
    private Set<AccountEntity> accountEntities;
}
