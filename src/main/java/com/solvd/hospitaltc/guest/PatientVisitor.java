package com.solvd.hospitaltc.guest;

import com.solvd.hospitaltc.status.HospitalVisitorStatus;
import com.solvd.hospitaltc.util.CustomContaminationAnnotation;
import com.solvd.hospitaltc.worker.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CustomContaminationAnnotation(status = "OUTSIDE CONTAMINATION")
public class PatientVisitor extends HospitalGuest {

    private static final Logger log = LogManager.getLogger(PatientVisitor.class);
    private Patient patientToVisit;
    private HospitalVisitorStatus status;

    public PatientVisitor(Patient patientToVisit, String guestId,
                          String name, boolean allowed) {

        super(guestId, name, allowed);
        this.patientToVisit = patientToVisit;
    }

    @Override
    protected void checkIsAllowed() {
        if (allowed) {
            log.info("Hello, {}welcome!", name);
        } else {
            log.info("Sorry, {}you've been denied visit to the patient(", name);
        }
    }


    public void guestVisiting() {
        log.info("Hello, my name is {} i'm visiting {}", name, patientToVisit.getLastName());
    }

    public Patient getPatientToVisit() {
        return patientToVisit;
    }

    public void setPatientToVisit(Patient patientToVisit) {
        this.patientToVisit = patientToVisit;
    }

    public HospitalVisitorStatus getStatus() {
        return status;
    }

    public void setStatus(HospitalVisitorStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("guest name:" + name)
                .append("\nguest id:" + guestId)
                .append("\nis guest allowed:" + allowed)
                .append("\nguest vissiting:" + patientToVisit);

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PatientVisitor otherVisitor = (PatientVisitor) obj;
        return otherVisitor.getName().equals(this.getName())
                && otherVisitor.getGuestId().equals(this.guestId);

    }


    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.guestId, this.getName());
    }

}
