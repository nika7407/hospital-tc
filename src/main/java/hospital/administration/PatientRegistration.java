package hospital.administration;

import hospital.worker.Patient;

import java.time.LocalDateTime;

public class PatientRegistration {

    @FunctionalInterface
    public interface Registration {
        Patient patientRegistration();
    }

    public static Patient register() {
        Registration registration = () -> new Patient(
                "Default",
                "Patient",
                0,
                "default@email.com",
                "0000",
                LocalDateTime.now(),
                0,
                false
        );
        Patient newPatient = registration.patientRegistration();
        System.out.println("Registered patient: " + newPatient.getFirstName() + " " + newPatient.getLastName() + ", age: " + newPatient.getAge());
        return newPatient;
    }
}
