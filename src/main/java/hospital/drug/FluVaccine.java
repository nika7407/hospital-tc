package hospital.drug;

public class FluVaccine implements Vaccine {
    @Override
    public void vaccinate() {
        System.out.println("\nyou have been vaccinayed from the flu" +
                "\ndont do sports for 5 days");
    }

    @Override
    public void printMinimalAge() {
        System.out.println("minimal age" + vaccinnationMinimalAge);
    }
}

