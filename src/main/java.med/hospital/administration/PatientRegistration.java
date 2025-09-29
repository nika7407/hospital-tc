package hospital.administration;

import hospital.lambda.Registration;
import hospital.worker.Patient;

public class PatientRegistration {

    public static Patient register(Registration registration) {

        Patient newPatient = registration.patientRegistration();
        System.out.println("Registered patient: " + newPatient.getFirstName() + " " + newPatient.getLastName() + ", age: " + newPatient.getAge());
        return newPatient;
    }
}
