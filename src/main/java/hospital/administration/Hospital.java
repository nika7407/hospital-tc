package hospital.administration;

import hospital.building.Department;
import hospital.guest.HospitalGuest;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hospital {

    private String name;
    private Map<String, Department> departments;
    private List<Appointment> appointments;
    private Set<HospitalGuest> guests;

    public Hospital(String name, Map<String, Department> departments, List<Appointment> appointments) {
        this.name = name;
        this.departments = departments;
        this.appointments = appointments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, Department> departments) {
        this.departments = departments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<HospitalGuest> getGuests() {
        return guests;
    }

    public void setGuests(Set<HospitalGuest> guests) {
        this.guests = guests;
    }
}
