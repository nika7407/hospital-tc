package hospital.administration;

import hospital.worker.Patient;

import java.util.Set;
import java.util.function.Predicate;

public class VaccinationProcedure {

    public static void testForVaccine(Set<Patient> patients, Predicate<Patient> vaccinationNeeded) {

        System.out.println("\n Vaccination procedure:");

        patients.stream()
                .filter(vaccinationNeeded)
                .forEach(patient ->
                        System.out.println(patient.getLastName() + " needs Vaccination!")
                );
    }
}
