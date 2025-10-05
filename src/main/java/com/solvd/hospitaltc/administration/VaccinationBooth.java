package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.drug.Vaccine;
import com.solvd.hospitaltc.exception.WrongAgeRuntimeException;
import com.solvd.hospitaltc.worker.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VaccinationBooth {

    private static final Logger logger = LogManager.getLogger(VaccinationBooth.class);

    public static void checkForTheVaccination(Vaccine vaccine, Patient patient) {

        int age = patient.getAge();

        if (vaccine.getVaccinationMinimalAge() > age) {
            throw new WrongAgeRuntimeException(age, "Vaccination");
        }

        boolean added = patient.getVaccines().add(vaccine);
        if (added) {
            logger.info("{}you have been vaccinated! amount of vaccines = {}", patient.getFirstName(), patient.getVaccines().size());
        } else {
            logger.info("{} already has this vaccine! amount of vaccines = {}", patient.getFirstName(), patient.getVaccines().size());
        }
    }
}
