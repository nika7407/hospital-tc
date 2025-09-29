package hospital.exception;

public class WrongAgeRuntimeException extends RuntimeException {

    public WrongAgeRuntimeException(int age, String action) {
        super("Age: " + age + " is Wrong to do" + action);
    }
}
