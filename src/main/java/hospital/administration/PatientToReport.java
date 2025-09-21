package hospital.administration;

import hospital.worker.Patient;

public class PatientToReport {

    @FunctionalInterface
    public interface Report {
        void patientToReport(Patient patient);
    }

    public static void report(Patient patient) {
        Report report = pat -> {

            System.out.println("\npatient report: " + pat.getFirstName() + " " + pat.getLastName() + ", age: " + pat.getAge());
        };
        report.patientToReport(patient);
    }
}
