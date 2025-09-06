package hospital.worker;

import hospital.building.Department;

public class Doctor extends Human {

    private int expirienceYears;
    private String spetialization;

    public Doctor(String firstName,
                  String lastName,
                  int age,
                  String email,
                  String spetialization, int expirienceYears) {

        super(firstName, lastName, age, email);
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

}
