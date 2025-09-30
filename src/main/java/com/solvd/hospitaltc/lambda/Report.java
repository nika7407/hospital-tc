package com.solvd.hospitaltc.lambda;

import com.solvd.hospitaltc.worker.Patient;

@FunctionalInterface
public interface Report {
    void patientToReport(Patient patient);
}