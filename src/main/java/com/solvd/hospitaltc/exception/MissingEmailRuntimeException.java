package com.solvd.hospitaltc.exception;

public class MissingEmailRuntimeException extends RuntimeException {

    public MissingEmailRuntimeException(String message) {
        super(message);
    }

    public MissingEmailRuntimeException(String message, Exception cause) {
        super(message, cause);
    }
}
