package hospital.sertification;

import hospital.lambda.NurseCertificateRegistration;
import hospital.worker.Nurse;

public class CertificateRegistration {

    public static void nurseCertification(Nurse nurse, Certificate certificate,
                                          NurseCertificateRegistration registration) {

        registration.addCertificate(nurse, certificate);
    }
}
