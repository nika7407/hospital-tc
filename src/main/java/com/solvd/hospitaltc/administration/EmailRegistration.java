package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.exception.MissingEmailRuntimeException;
import com.solvd.hospitaltc.exception.WrongEmailException;
import com.solvd.hospitaltc.worker.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailRegistration implements AutoCloseable {

    private final String email;
    boolean wrong = false;
    private static final Logger logger = LogManager.getLogger(EmailRegistration.class);


    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    public EmailRegistration(Human user) {
        if (user.getEmail() == null) {
            logger.error("MissingEmailRuntimeException(\"missing email\")");
            throw new MissingEmailRuntimeException("missing email");
        }

        this.email = user.getEmail();
        logger.info("Email.registration Started!");
    }

    public void registerEmail() {
        if (!email.matches(EMAIL_REGEX)) {
            logger.warn("wrong  Email!");
        } else {
            wrong = true;
            logger.info("{} is registered!", email);
            logger.info("Email Registration Finished!");
        }
    }

    @Override
    public void close() throws Exception {
        if (wrong) {
            logger.info("Registration service is closed!");
        } else {
            logger.error("WrongEmailException(\"wrong email!\")");
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
