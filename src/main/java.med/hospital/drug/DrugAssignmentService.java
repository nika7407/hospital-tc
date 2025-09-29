package hospital.drug;

import hospital.worker.Patient;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class DrugAssignmentService {

    public static void assignDrug(Drug drug, Patient patient) {
        // unapproved drugs won't be assigned
        if (!drug.isAprroved()) {
            System.out.println("Sorry," + patient.getFirstName()
                    + " Drug is not approved for Use\nTalk with your Doctor");
            return;
        }

        List<Drug> assignedDrugs = patient.getAssignedDrugs();
        assignedDrugs.add(drug);

        Consumer<Patient> assignDrug = pat1 -> {
            patient.setAssignedDrugs(assignedDrugs);
        };
        assignDrug.accept(patient);
        System.out.println("Drug assigned for " + patient.getFirstName());
    }

    public static void difficultyCheck(Patient patient, ToIntFunction<Patient> diffReCheck) {

        patient.setDifficultyScale(diffReCheck.applyAsInt(patient));
    }
}
