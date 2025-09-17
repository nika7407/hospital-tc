package hospital.building;

import hospital.worker.Doctor;
import hospital.worker.Nurse;
import hospital.worker.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Psychiatric extends Department {

    private Set<Patient> committedPatients;
    private boolean aggressive;

    public Psychiatric(List<Doctor> doctors,
                       Set<Patient> patients,
                       List<Nurse> nurses,
                       List<Apparatus> apparatuses,
                       String name,
                       int capacity,
                       Set<Patient> committedPatients,
                       boolean aggressive) {
        super(doctors, patients, nurses, apparatuses, name, capacity, new HashMap<>());
        this.committedPatients = committedPatients;
        this.aggressive = aggressive;
    }

    public Set<Patient> getCommittedPatients() {
        return committedPatients;
    }

    public void setCommittedPatients(Set<Patient> committedPatients) {
        this.committedPatients = committedPatients;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }
}
