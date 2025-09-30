package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.lambda.Registration;
import com.solvd.hospitaltc.worker.Patient;

public class PatientRegistration {

    public static Patient register(Registration registration) {

        Patient newPatient = registration.patientRegistration();
        System.out.println("Registered patient: " + newPatient.getFirstName() + " " + newPatient.getLastName() + ", age: " + newPatient.getAge());
        return newPatient;
    }
}
