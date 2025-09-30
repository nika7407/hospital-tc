package com.solvd.hospitaltc.lambda;

import com.solvd.hospitaltc.sertification.Certificate;
import com.solvd.hospitaltc.worker.Nurse;

@FunctionalInterface
public interface NurseCertificateRegistration {

    void addCertificate(Nurse nurse, Certificate certificate);
}