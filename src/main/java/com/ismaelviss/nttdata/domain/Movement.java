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
}
