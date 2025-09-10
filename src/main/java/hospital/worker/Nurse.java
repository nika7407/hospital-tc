package hospital.worker;

import hospital.building.Department;
import hospital.sertification.Sertificate;

import java.security.cert.Certificate;

public class Nurse extends Human {

    private int expirienceYears;
    private boolean practise;
    private Sertificate sertificate;

    public Nurse(String firstName,
                 String lastName,
                 int age, String email,
                 int expirienceYears, boolean practise) {
        super(firstName, lastName, age, email);
        this.expirienceYears = expirienceYears;
        this.practise = practise;
    }

    public int getExpirienceYears() {
        return expirienceYears;
    }

    public void setExpirienceYears(int expirienceYears) {
        this.expirienceYears = expirienceYears;
    }

    public boolean isPractise() {
        return practise;
    }

    public void setPractise(boolean practise) {
        this.practise = practise;
    }

    public Sertificate getSertificate() {
        return sertificate;
    }

    public void setSertificate(Sertificate sertificate) {
        this.sertificate = sertificate;
    }
}
