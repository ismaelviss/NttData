package com.ismaelviss.nttdata.domain;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class Account {
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Boolean state;
}
