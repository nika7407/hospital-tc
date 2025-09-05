package hospital.worker;

import hospital.building.Department;

public class Nurse extends Human {

    private int expirienceYears;
    private Department department;
    private boolean practise;

    public Nurse(String firstName,
                 String lastName,
                 int age, String email,
                 int expirienceYears, Department department, boolean practise) {
        super(firstName, lastName, age, email);
        this.expirienceYears = expirienceYears;
        this.department = department;
        this.practise = practise;
    }

    public int getExpirienceYears() {
        return expirienceYears;
    }

    public void setExpirienceYears(int expirienceYears) {
        this.expirienceYears = expirienceYears;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isPractise() {
        return practise;
    }

    public void setPractise(boolean practise) {
        this.practise = practise;
    }
}
