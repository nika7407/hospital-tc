package hospital.lambda;

import hospital.worker.Patient;

@FunctionalInterface
public interface Registration {
    Patient patientRegistration();
}