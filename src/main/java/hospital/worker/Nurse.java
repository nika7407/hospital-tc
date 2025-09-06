package hospital.worker;

import hospital.building.Department;

public class Nurse extends Human {

    private int expirienceYears;
    private boolean practise;

    public Nurse(String firstName,
                 String lastName,
                 int age, String email,
                 int expirienceYears, boolean practise) {
        super(firstName, lastName, age, email);
        this.expirienceYears = expirienceYears;
        this.practise = practise;
    }

    public int getExpirienceYears() {
        return expirienceYears;
    }

    public void setExpirienceYears(int expirienceYears) {
        this.expirienceYears = expirienceYears;
    }

    public boolean isPractise() {
        return practise;
    }

    public void setPractise(boolean practise) {
        this.practise = practise;
    }
}
