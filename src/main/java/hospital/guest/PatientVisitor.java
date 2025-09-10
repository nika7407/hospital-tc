package hospital.guest;

import hospital.worker.Patient;

public class PatientVisitor extends HospitalGuest {

    private Patient patientToVisit;

    public PatientVisitor(Patient patientToVisit, String guestId,
                          String name, boolean allowed) {

        super(guestId, name, allowed);
        this.patientToVisit = patientToVisit;
    }

    @Override
    protected void checkIsAllowed() {
        if (allowed) {
            System.out.println("Hello, " + name + "welcome!");
        } else {
            System.out.println("Sorry, " + name + "you've been denied visit to the patient(");
        }
    }


    public void guestVisiting() {
        System.out.println("Hello, my name is " + name + " i'm visiting " + patientToVisit.getLastName());
    }

    public Patient getPatientToVisit() {
        return patientToVisit;
    }

    public void setPatientToVisit(Patient patientToVisit) {
        this.patientToVisit = patientToVisit;
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
