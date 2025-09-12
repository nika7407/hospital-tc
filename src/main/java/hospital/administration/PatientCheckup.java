package hospital.administration;

import hospital.worker.Patient;

public final class PatientCheckup implements Checkup<Patient> {

    public void checkup(Patient patientToCheck) {

        if (patientToCheck == null) {
            System.out.println("\nPatient is missing(");
        }

        int amountOfAssignedDrugs = patientToCheck.getAssignedDrugs().length;

        StringBuilder checkup = new StringBuilder();
        checkup.append("\npatient: ")
                .append(patientToCheck.getFirstName() + " " + patientToCheck.getLastName())
                .append("\namount of drugs: " + amountOfAssignedDrugs);

        if (amountOfAssignedDrugs > 3) {
            checkup.append("\nrecommendation: lower dosage");
        } else {
            checkup.append("\nrecommendation: keep dosage");
        }

        System.out.println(checkup.toString());
    }
}
