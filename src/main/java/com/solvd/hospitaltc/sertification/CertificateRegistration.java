package com.solvd.hospitaltc.sertification;

import com.solvd.hospitaltc.lambda.NurseCertificateRegistration;
import com.solvd.hospitaltc.worker.Nurse;

public class CertificateRegistration {

    public static void nurseCertification(Nurse nurse, Certificate certificate,
                                          NurseCertificateRegistration registration) {

        registration.addCertificate(nurse, certificate);
    }
}
