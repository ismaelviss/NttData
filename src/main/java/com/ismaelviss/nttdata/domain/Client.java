package com.ismaelviss.nttdata.domain;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@Validated
public class Client {


    private Long clientId;

    @Max(value = 250, message = "maximo 250 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]{1,250}+$", message = "Los valores permitidos son letras, números y caracteres espaciales como: -,_,.,(,)")
    private String name;

    @Max(value = 250, message = "maximo 250 caracteres")
    @Pattern(regexp = "([A-Za-z0-9-_.\\(\\)\\À-ÿ\\\\u00f1\\\\u00d1 ]){1,250}+$", message = "Los valores permitidos son letras, números y caracteres espaciales como: -,_,.,(,)")
    private String address;

    @Max(value = 20, message = "maximo 20 caracteres")
    @Pattern(regexp = "^([+]|[0-9])[0-9]{1,20}+$", message = "Los valores permitidos son números y +")
    private String phoneNumber;

    @Min(value = 4, message = "minimo 4 caracteres")
    @Max(value = 4, message = "maximo 4 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "Solo se permite valores numericos")
    private String password;

    private Boolean state;

    private String gender;
    private Integer age;
    private String identification;

    public static final String MALE = "Masculino";
    public static final String FEMALE = "Femenino";
}
