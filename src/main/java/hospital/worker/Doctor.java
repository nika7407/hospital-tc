package hospital.worker;

import hospital.building.Department;

public class Doctor extends Human {

    private int expirienceYears;
    private String spetialization;
    private Department department;

    public Doctor(String firstName,
                  String lastName,
                  int age,
                  String email,
                  Department department, String spetialization, int expirienceYears) {

        super(firstName, lastName, age, email);
        this.department = department;
        this.spetialization = spetialization;
        this.expirienceYears = expirienceYears;
    }

    public int getExpirienceYears() {
        return expirienceYears;
    }

    public void setExpirienceYears(int expirienceYears) {
        this.expirienceYears = expirienceYears;
    }

    public String getSpetialization() {
        return spetialization;
    }

    public void setSpetialization(String spetialization) {
        this.spetialization = spetialization;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
