package hospital.building;

import hospital.worker.Doctor;
import hospital.worker.Nurse;
import hospital.worker.Patient;

public class Department {

    private Doctor[] doctors;
    private Patient[] patients;
    private Nurse[] nurses;
    private Apparatus[] apparatuses;
    private String name;
    private int capacity;

    public Department(Doctor[] doctors, Patient[] patients, Nurse[] nurses, Apparatus[] apparatuses,
                      String name, int capacity) {
        this.doctors = doctors;
        this.patients = patients;
        this.nurses = nurses;
        this.apparatuses = apparatuses;
        this.name = name;
        this.capacity = capacity;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public Nurse[] getNurses() {
        return nurses;
    }

    public void setNurses(Nurse[] nurses) {
        this.nurses = nurses;
    }

    public void setApparatuses(Apparatus[] apparatuses) {
        this.apparatuses = apparatuses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Apparatus[] getApparatus() {
        return apparatuses;
    }
}
