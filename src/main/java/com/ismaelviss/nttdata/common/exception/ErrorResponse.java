package com.ismaelviss.nttdata.common.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String code;
    private String message;
}
