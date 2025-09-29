package hospital.administration;

import hospital.worker.Doctor;
import hospital.worker.Patient;

import java.time.LocalDateTime;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private LocalDateTime date;
    private boolean isFinished;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime date, boolean isFinished) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.isFinished = isFinished;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
