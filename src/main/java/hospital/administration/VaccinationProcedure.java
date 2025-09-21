package hospital.administration;

import hospital.worker.Patient;

import java.util.Set;
import java.util.function.Predicate;

public class VaccinationProcedure {

    public static void testForVaccine(Set<Patient> patients) {

        Predicate<Patient> vaccinationNeeded = patient -> {
            return !patient.getVaccines().isEmpty();
        };

        System.out.println("\n Vaccination procedure:");

        patients.forEach(patient -> {
            if (vaccinationNeeded.test(patient)) {
                System.out.println(patient.getLastName() + " needs Vaccination!");
            }
        });
    }
}
