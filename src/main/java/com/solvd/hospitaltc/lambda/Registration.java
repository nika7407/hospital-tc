package com.solvd.hospitaltc.lambda;

import com.solvd.hospitaltc.worker.Patient;

@FunctionalInterface
public interface Registration {
    Patient patientRegistration();
}