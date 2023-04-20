package com.ismaelviss.nttdata.adapter.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "initial_balance")
    private Double initialBalance;
    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ClientEntity clientEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<MovementEntity> movementEntities;
}
