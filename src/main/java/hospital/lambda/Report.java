package hospital.lambda;

import hospital.worker.Patient;

@FunctionalInterface
public interface Report {
    void patientToReport(Patient patient);
}