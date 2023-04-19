package com.ismaelviss.nttdata.common.exception;

public class ApplicationException extends Exception{
    private String code;
    private String message;
    public ApplicationException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
