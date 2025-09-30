package hospital.exception;

public class MissingPatientRuntimeException extends RuntimeException {

    public MissingPatientRuntimeException(String message) {
        super(message);
    }

    public MissingPatientRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
