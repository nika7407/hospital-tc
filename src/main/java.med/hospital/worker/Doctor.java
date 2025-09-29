package hospital.worker;

public class Doctor extends Human {

    private int expirienceYears;
    private String field;
    private Spetialization spetialization;

    public Doctor(String firstName,
                  String lastName,
                  int age,
                  String email,
                  String spetialization, int expirienceYears) {

        super(firstName, lastName, age, email);
        this.field = spetialization;
        this.expirienceYears = expirienceYears;
    }

    public int getExpirienceYears() {
        return expirienceYears;
    }

    public void setExpirienceYears(int expirienceYears) {
        this.expirienceYears = expirienceYears;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Spetialization getSpetialization() {
        return spetialization;
    }

    public void setSpetialization(Spetialization spetialization) {
        this.spetialization = spetialization;
    }
}
