package hospital.drug;

public final class MeaslesVaccine implements Vaccine {
    private final static int daysOfNotDrinking = 3;

    @Override
    public void vaccinate() {
        System.out.println("\nyou have been vaccinated by: measles vaccine" +
                "\ndont drink for " + daysOfNotDrinking + " days");
    }

    @Override
    public int getVaccinationMinimalAge() {
        return VACCINATION_MINIMAL_AGE;
    }

    public static void isVaccineHarmful() {
        System.out.println("\nno the vaccine is not harmful!");
    }
}
