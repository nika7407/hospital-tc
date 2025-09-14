package hospital.exception;

public class MissingDateRuntimeException extends RuntimeException {

    public MissingDateRuntimeException(String message) {
        super(message);
    }

    public MissingDateRuntimeException(String message, Throwable cause) {
        super(message);
    }
}
