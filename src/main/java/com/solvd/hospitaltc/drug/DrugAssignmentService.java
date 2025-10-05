package com.solvd.hospitaltc.drug;

import com.solvd.hospitaltc.worker.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class DrugAssignmentService {

    private static final Logger log = LogManager.getLogger(DrugAssignmentService.class);

    public static void assignDrug(Drug drug, Patient patient) {
        // unapproved drugs won't be assigned
        if (!drug.isAprroved()) {
            log.info("Sorry,{} Drug is not approved for Use, Talk with your Doctor", patient.getFirstName());
            return;
        }

        List<Drug> assignedDrugs = patient.getAssignedDrugs();
        assignedDrugs.add(drug);

        Consumer<Patient> assignDrug = pat1 -> {
            patient.setAssignedDrugs(assignedDrugs);
        };
        assignDrug.accept(patient);
        log.info("Drug assigned for {}", patient.getFirstName());
    }

    public static void difficultyCheck(Patient patient, ToIntFunction<Patient> diffReCheck) {

        patient.setDifficultyScale(diffReCheck.applyAsInt(patient));
    }
}
