package hospital.administration;

import hospital.building.Department;

public class Catalogue {

    private Department[] departments;
    private Appointment[] appointments;

    public Catalogue(Department[] departments, Appointment[] appointments) {
        this.departments = departments;
        this.appointments = appointments;
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

    public void printDepartments() {
        System.out.println("\ndepartments");
        for (Department department : departments) {
            System.out.println(" " + department.getName());
        }
    }

    public void printAppointments() {
        System.out.println("\nappointments");
        for (Appointment appointment : appointments) {
            System.out.println("patient" + appointment.getPatient().getFirstName()
                    + " doctor: " + appointment.getDoctor().getFirstName()
                    + " date: " + appointment.getDate());
        }
    }
}
