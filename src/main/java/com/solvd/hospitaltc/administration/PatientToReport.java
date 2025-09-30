package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.lambda.Report;
import com.solvd.hospitaltc.worker.Patient;

public class PatientToReport {

    public static void report(Patient patient, Report function) {
        function.patientToReport(patient);
    }
}
