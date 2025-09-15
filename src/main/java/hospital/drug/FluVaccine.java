package hospital.drug;

public class FluVaccine implements Vaccine {

    @Override
    public void vaccinate() {
        System.out.println("\nyou have been vaccinated from the flu" +
                "\ndon't do sports for 5 days");
    }

    @Override
    public int getVaccinationMinimalAge() {
        return VACCINATION_MINIMAL_AGE;
    }
}

