package com.solvd.hospitaltc.exception;

public class MissingDoctorRuntimeException extends RuntimeException {

    public MissingDoctorRuntimeException(String message) {
        super(message);
    }

    public MissingDoctorRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
