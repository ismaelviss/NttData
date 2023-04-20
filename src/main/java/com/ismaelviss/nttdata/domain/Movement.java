package com.ismaelviss.nttdata.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;


@Data
@Validated
public class Movement {
    private Long id;
    private LocalDateTime date;

    @Pattern(regexp = "(Debito|Credito)", message = "Debito ó Credito")
    private String movementType;

    @NotNull
    @NotBlank
    private Double amount;

    private Double balance;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[0-9]+$", message = "Solo se permite valores numericos")
    private String accountNumber;

    public static final String DEBIT = "Debito";
    public static final String CREDIT = "Credito";
}
