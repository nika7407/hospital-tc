package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.exception.CheckupException;
import com.solvd.hospitaltc.exception.MissingPatientRuntimeException;
import com.solvd.hospitaltc.worker.Patient;

public final class PatientCheckup implements Checkup<Patient> {

    public void checkup(Patient patientToCheck) throws CheckupException {

        if (patientToCheck == null) {
            throw new MissingPatientRuntimeException("Missing the patient!");
        }

        int amountOfAssignedDrugs = patientToCheck.getAssignedDrugs().size();

        StringBuilder checkup = new StringBuilder();
        checkup.append("\npatient: ")
                .append(patientToCheck.getFirstName() + " " + patientToCheck.getLastName())
                .append("\namount of drugs: " + amountOfAssignedDrugs);

        if (amountOfAssignedDrugs > 3) {
            checkup.append("\nrecommendation: lower dosage");
        } else if (amountOfAssignedDrugs == 0) {
            throw new CheckupException("patient doest takes drugs!");
        } else {
            checkup.append("\nrecommendation: keep dosage");
        }

        System.out.println(checkup.toString());
    }
}
