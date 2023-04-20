package com.ismaelviss.nttdata.domain;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;


@Data
@Validated
public class Movement {
    private Long id;
    private LocalDateTime date;
    private String movementType;
    private Double amount;
    private Double balance;

    public static final String DEBIT = "Debito";
    public static final String CREDIT = "Credito";
}
