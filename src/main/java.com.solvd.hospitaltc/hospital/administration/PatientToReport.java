package hospital.administration;

import hospital.lambda.Report;
import hospital.worker.Patient;

public class PatientToReport {

    public static void report(Patient patient, Report function) {
        function.patientToReport(patient);
    }
}
