package com.ismaelviss.nttdata.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movement")
public class MovementEntity {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime date;
    private String movementType;
    private Double amount;
    private Double balance;

    @ManyToOne
    @JoinColumn(name="accountNumber", nullable = false)
    private AccountEntity accountEntity;
}
