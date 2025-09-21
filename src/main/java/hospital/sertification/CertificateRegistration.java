package hospital.sertification;

import hospital.worker.Nurse;

public class CertificateRegistration {

    @FunctionalInterface
    interface NurseCertificateRegistration {
        void addCertificate(Nurse nurse, Certificate certificate);
    }

    public static void nurseCertification(Nurse nurse, Certificate certificate) {

        NurseCertificateRegistration registration = (nurs, cert) -> {
            if (nurs.getSertificate() == null) {
                nurs.setSertificate(cert);
            }
        };
        registration.addCertificate(nurse, certificate);
    }
}
