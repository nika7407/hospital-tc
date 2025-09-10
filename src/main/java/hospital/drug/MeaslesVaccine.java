package hospital.drug;

public final class MeaslesVaccine implements Vaccine {
    private final static int daysOfNotDrinking = 3;

    @Override
    public final void vaccinate() {
        System.out.println("\nyou have been vaccinated by: measles vaccine" +
                "\ndont drink for " + daysOfNotDrinking + " days");
    }

    @Override
    public void printMinimalAge() {
        System.out.println("\nminimal age is " + vaccinnationMinimalAge);
    }

    public static void isVaccineHarmful(){
        System.out.println("\nno the vaccine is not harmful!");
    }
}
