package hospital.administration;

import hospital.building.Department;
import hospital.guest.Guest;

public class Hospital {

    private String name;
    private Department[] departments;
    private Appointment[] appointments;
    private Catalogue catalogue;
    private Guest[] guests;

    public Hospital(String name, Department[] departments, Appointment[] appointments) {
        this.name = name;
        this.departments = departments;
        this.appointments = appointments;
        this.catalogue = new Catalogue(departments, appointments);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment[] appointments) {
        this.appointments = appointments;
    }

    public Catalogue getHospitalCatalogue() {
        return catalogue;
    }

    public void setHospitalCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Guest[] getGuests() {
        return guests;
    }

    public void setGuests(Guest[] guests) {
        this.guests = guests;
    }
}
