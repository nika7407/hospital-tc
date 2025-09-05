package hospital.administration;

import hospital.worker.Doctor;
import hospital.worker.Patient;

import java.time.LocalDateTime;

public class AppointmentService {

    private static int totalAppointments = 0;

    static {
        System.out.println("Appointment Service started");
    }

    public static Appointment createAppointment(Patient patient, Doctor doctor, LocalDateTime date) {
        if (patient == null || doctor == null || date == null) {
            System.out.println("Error: Missing appointment details");
            return null;
        }
        Appointment appointment = new Appointment(patient, doctor, date, false);
        totalAppointments++;
        return appointment;
    }

    public static void completeAppointment(Appointment appointment) {
        if (appointment != null && !appointment.isFinished()) {
            appointment.setFinished(true);
            System.out.println("Appointment completed for: " + appointment.getPatient().getFirstName());
        }
    }
}
