package com.solvd.hospitaltc.building;

import com.solvd.hospitaltc.worker.Doctor;
import com.solvd.hospitaltc.worker.Nurse;
import com.solvd.hospitaltc.worker.Patient;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Department {

    private List<Doctor> doctors;
    private Set<Patient> patients;
    private List<Nurse> nurses;
    private List<Apparatus> apparatuses;
    private String name;
    private int capacity;
    private Map<Patient, String> notes;

    public Department(List<Doctor> doctors, Set<Patient> patients, List<Nurse> nurses, List<Apparatus> apparatuses,
                      String name, int capacity, Map<Patient, String> notes) {
        this.doctors = doctors;
        this.patients = patients;
        this.nurses = nurses;
        this.apparatuses = apparatuses;
        this.name = name;
        this.capacity = capacity;
        this.notes = notes;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public void setApparatuses(List<Apparatus> apparatuses) {
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

    public List<Apparatus> getApparatus() {
        return apparatuses;
    }

    public Map<Patient, String> getPatientNotes() {
        return notes;
    }

    public void setPatientNotes(Map<Patient, String> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
