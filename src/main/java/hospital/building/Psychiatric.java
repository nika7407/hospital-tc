package hospital.building;

import hospital.worker.Doctor;
import hospital.worker.Nurse;
import hospital.worker.Patient;

public class Psychiatric extends Department {

    private Patient[] committedPatients;
    private boolean isAggressive;

    public Psychiatric(Doctor[] doctors,
                       Patient[] patients,
                       Nurse[] nurses,
                       Apparatus[] apparatuses,
                       String name,
                       int capacity,
                       Patient[] committefPatients,
                       boolean isAggressive) {

        super(doctors, patients, nurses, apparatuses, name, capacity);
        this.committedPatients = committefPatients;
        this.isAggressive = isAggressive;
    }

    public Patient[] getCommittedPatients() {
        return committedPatients;
    }

    public void setCommittedPatients(Patient[] committedPatients) {
        this.committedPatients = committedPatients;
    }

    public boolean isAggressive() {
        return isAggressive;
    }

    public void setAggressive(boolean aggressive) {
        isAggressive = aggressive;
    }
}
