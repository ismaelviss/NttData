package com.ismaelviss.nttdata.domain;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class Account {

    @NotNull
    @NotBlank
    @Size(min = 4, max = 20, message = "de 4 a 20 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "Solo se permite valores numericos")
    private String accountNumber;

    @NotNull
    @NotBlank
    @Pattern(regexp = "(Ahorros|Corriente)", message = "Ahorros ó Corriente")
    private String accountType;

    @NotNull
    @Min(value = 1, message = "el saldo inicial debe ser mayor a 0")
    private Double initialBalance;

    @NotNull
    private Boolean state;

    @NotNull
    private Long clientId;

    public static final String SAVINGS_ACCOUNT = "Ahorros";
    public static final String CURRENT_ACCOUNT = "Corriente";
}
