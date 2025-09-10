package hospital.worker;

import hospital.drug.Drug;
import hospital.drug.Vaccine;

import java.time.LocalDateTime;

public class Patient extends Human {

    private String medicalId;
    private LocalDateTime commitDate;
    private int difficultyScale;
    private boolean dnr;
    private Drug[] assignedDrugs = new Drug[0];
    private Vaccine[] vaccines = new Vaccine[0];

    public Patient(String firstName,
                   String lastName,
                   int age, String email,
                   String medicalId,
                   LocalDateTime commitDate,
                   int difficultyScale, boolean dnr) {
        super(firstName, lastName, age, email);
        this.medicalId = medicalId;
        this.commitDate = commitDate;
        this.difficultyScale = difficultyScale;
        this.dnr = dnr;
    }

    public void setMedicalId(String medicalId) {
        this.medicalId = medicalId;
    }

    public void setCommitDate(LocalDateTime commitDate) {
        this.commitDate = commitDate;
    }

    public void setDifficultyScale(int difficultyScale) {
        if (difficultyScale < 0 || difficultyScale > 10) {
            System.out.println("incorrect difficulty");
            return;
        }
        this.difficultyScale = difficultyScale;
    }

    public void setDnr(boolean dnr) {
        this.dnr = dnr;
    }

    public String getMedicalId() {
        return medicalId;
    }

    public LocalDateTime getCommitDate() {
        return commitDate;
    }

    public boolean isDnr() {
        return dnr;
    }

    public int getDifficultyScale() {
        return difficultyScale;
    }

    public Drug[] getAssignedDrugs() {
        return assignedDrugs;
    }

    public void setAssignedDrugs(Drug[] assignedDrugs) {
        this.assignedDrugs = assignedDrugs;
    }

    public Vaccine[] getVaccines() {
        return vaccines;
    }

    public void setVaccines(Vaccine[] vaccines) {
        this.vaccines = vaccines;
    }
}
