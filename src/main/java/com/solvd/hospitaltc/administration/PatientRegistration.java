package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.lambda.Registration;
import com.solvd.hospitaltc.worker.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatientRegistration {

    private static final Logger logger = LogManager.getLogger(PatientRegistration.class);

    public static Patient register(Registration registration) {

        Patient newPatient = registration.patientRegistration();

        logger.info("Registered patient: {} {}, age: {}", newPatient.getFirstName(), newPatient.getLastName(), newPatient.getAge());
        return newPatient;
    }
}
