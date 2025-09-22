package hospital.lambda;

import hospital.sertification.Certificate;
import hospital.worker.Nurse;

@FunctionalInterface
public interface NurseCertificateRegistration {

    void addCertificate(Nurse nurse, Certificate certificate);
}