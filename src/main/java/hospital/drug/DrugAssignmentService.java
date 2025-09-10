package hospital.drug;

import hospital.worker.Patient;

public class DrugAssignmentService  {

    public static void assignDrug(Drug drug, Patient patient) {
        // unapproved drugs won't be assigned
        if (!drug.isAprroved()) {
            System.out.println("Soory," + patient.getFirstName() + " Drug is not aprroved for Use\nTalk with your Doctor");
            return;
        }

        Drug[] assignedDrugs = patient.getAssignedDrugs();
        int amountOfAssignedDrugs = assignedDrugs.length;

        Drug[] newAssignedDrugs = new Drug[amountOfAssignedDrugs + 1];

        System.arraycopy(assignedDrugs, 0, newAssignedDrugs, 0, amountOfAssignedDrugs);
        newAssignedDrugs[amountOfAssignedDrugs] = drug;

        patient.setAssignedDrugs(newAssignedDrugs);
        System.out.println("Drug assigned for " + patient.getFirstName());
    }

}

