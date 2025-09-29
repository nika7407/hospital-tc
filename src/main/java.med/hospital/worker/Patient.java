package hospital.worker;

import hospital.drug.Drug;
import hospital.drug.Vaccine;
import hospital.status.PatientIllness;
import hospital.status.PatientStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Patient extends Human {

    private String medicalId;
    private LocalDateTime commitDate;
    private int difficultyScale;
    private boolean dnr;
    private List<Drug> assignedDrugs = new ArrayList<>();
    private Set<Vaccine> vaccines = new HashSet<>();
    private PatientStatus patientStatus;
    private PatientIllness patientIllness;


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

    public List<Drug> getAssignedDrugs() {
        return assignedDrugs;
    }

    public void setAssignedDrugs(List<Drug> assignedDrugs) {
        this.assignedDrugs = assignedDrugs;
    }

    public Set<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(Set<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    public PatientIllness getPatientIllness() {
        return patientIllness;
    }

    public void setPatientIllness(PatientIllness patientIllness) {
        this.patientIllness = patientIllness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return medicalId != null && medicalId.equals(patient.medicalId);
    }

    @Override
    public int hashCode() {
        return medicalId != null ? medicalId.hashCode() : 0;
    }


}

