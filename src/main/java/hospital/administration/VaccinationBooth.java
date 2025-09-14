package hospital.administration;

import hospital.drug.Vaccine;
import hospital.exception.WrongAgeRuntimeException;
import hospital.worker.Patient;

public class VaccinationBooth {

    public static void checkForTheVaccination(Vaccine vaccine, Patient patient) {

        int age = patient.getAge();

        if (vaccine.getVaccinationMinimalAge() > age) {
            throw new WrongAgeRuntimeException(age, "Vaccination");
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
