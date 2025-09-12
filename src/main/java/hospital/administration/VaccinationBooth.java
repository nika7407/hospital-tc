package hospital.administration;

import hospital.drug.Vaccine;
import hospital.worker.Patient;

public class VaccinationBooth {

    public static void checkForTheVacination(Vaccine vaccine,
                                             Patient patient) {
        if (vaccine.getVaccinationMinimalAge() > patient.getAge()) {
            System.out.println("\nSorry your age is not enough to vaccinate!");
        }

        Vaccine[] oldVaccines = patient.getVaccines();
        int amountOfVaccines = oldVaccines.length;
        Vaccine[] newVaccines = new Vaccine[amountOfVaccines + 1];

        System.arraycopy(oldVaccines, 0, newVaccines, 0, amountOfVaccines);
        newVaccines[amountOfVaccines] = vaccine;
        patient.setVaccines(newVaccines);
        System.out.println("\n" + patient.getFirstName() + " you have been vaccinated!\n"
                + "amount of vaccines = " + newVaccines.length);
    }

}
