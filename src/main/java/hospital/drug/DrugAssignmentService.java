package hospital.drug;

import hospital.worker.Patient;

import java.util.List;

public class DrugAssignmentService {

    public static void assignDrug(Drug drug, Patient patient) {
        // unapproved drugs won't be assigned
        if (!drug.isAprroved()) {
            System.out.println("Sorry," + patient.getFirstName() + " Drug is not approved for Use\nTalk with your Doctor");
            return;
        }

        List<Drug> assignedDrugs = patient.getAssignedDrugs();
        assignedDrugs.add(drug);
        patient.setAssignedDrugs(assignedDrugs);
        System.out.println("Drug assigned for " + patient.getFirstName());
    }

}
