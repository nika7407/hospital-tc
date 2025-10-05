package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.worker.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;
import java.util.function.Predicate;

public class VaccinationProcedure {

    private static final Logger log = LogManager.getLogger(VaccinationProcedure.class);

    public static void testForVaccine(Set<Patient> patients, Predicate<Patient> vaccinationNeeded) {

        log.info("Vaccination procedure:");

        patients.stream()
                .filter(vaccinationNeeded)
                .forEach(patient ->
                        log.info("{} needs Vaccination!", patient.getLastName())
                );
    }
}
