package hospital.administration;

import hospital.exception.MissingEmailRuntimeException;
import hospital.exception.WrongEmailException;
import hospital.worker.Human;

public class EmailRegistration implements AutoCloseable {

    private final String email;
    boolean wrong = false;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    public EmailRegistration(Human user) {
        if (user.getEmail() == null) {
            throw new MissingEmailRuntimeException("missing email");
        }

        this.email = user.getEmail();
        System.out.println("\nEmail.registration Started!");
    }

    public void registerEmail() {
        if (!email.matches(EMAIL_REGEX)) {
            System.out.println("wrong  Email!");
        } else {
            wrong = true;
            System.out.println(email + " is registered!");
            System.out.println("Email Registration Finished!");
        }
    }

    @Override
    public void close() throws Exception {
        if (wrong) {
            System.out.println("\nRegistration service is closed!");
        } else {
            throw new WrongEmailException("wrong email!");
        }

    }

    public boolean isWrong() {
        return wrong;
    }

    public void setWrong(boolean wrong) {
        this.wrong = wrong;
    }
}
