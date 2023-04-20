package com.ismaelviss.nttdata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReportMovement {
    private LocalDateTime date;
    private String client;
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Boolean state;
    private Double amountMovement;
    private Double availableBalance;
}
