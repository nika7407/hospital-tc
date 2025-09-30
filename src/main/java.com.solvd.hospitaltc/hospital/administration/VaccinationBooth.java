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

        boolean added = patient.getVaccines().add(vaccine);
        if (added) {
            System.out.println("\n" + patient.getFirstName() + "you have been vaccinated!"
                    + "\namount of vaccines = " + patient.getVaccines().size());
        } else {
            System.out.println("\n" + patient.getFirstName() + " already has this vaccine!"
                    + "\namount of vaccines = " + patient.getVaccines().size());
        }
    }
}
