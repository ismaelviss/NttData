package com.ismaelviss.nttdata.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class Client {

    private Long clientId;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 250, message = "de 5 a 250 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "Los valores permitidos son letras, números y caracteres espaciales como: -,_,.,(,)")
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 250, message = "de 5 a 250 caracteres")
    @Pattern(regexp = "([A-Za-z0-9-_.\\(\\)\\À-ÿ\\\\u00f1\\\\u00d1 ])+$", message = "Los valores permitidos son letras, números y caracteres espaciales como: -,_,.,(,)")
    private String address;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 20, message = "de 10 a 20 caracteres")
    @Pattern(regexp = "^([+]|[0-9])[0-9]{1,20}+$", message = "Los valores permitidos son números y +")
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 4, message = "debe tener 4 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "Solo se permite valores numericos")
    private String password;

    @NotNull
    private Boolean state;

    @NotNull
    @NotBlank
    @Pattern(regexp = "(Masculino|Femenino)", message = "Masculino ó Femenino")
    private String gender;

    @NotNull
    private Integer age;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 20, message = "de 10 a 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Los valores permitidos son letras y números")
    private String identification;

    public static final String MALE = "Masculino";
    public static final String FEMALE = "Femenino";
}
