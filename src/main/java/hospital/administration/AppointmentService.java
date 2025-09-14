package hospital.administration;

import hospital.exception.MissingDoctorRuntimeException;
import hospital.exception.MissingPatientRuntimeException;
import hospital.worker.Doctor;
import hospital.worker.Patient;

import java.time.LocalDateTime;

public class AppointmentService implements AutoCloseable {

    private static int totalAppointments = 0;

    static {
        System.out.println("\nAppointment Service started");
    }

    public static Appointment createAppointment(Patient patient, Doctor doctor, LocalDateTime date) {

        if (patient == null) {
            throw new MissingPatientRuntimeException("missing patient!", new NullPointerException());
        } else if (doctor == null) {
            throw new MissingDoctorRuntimeException("missing doctor!", new NullPointerException());
        } else if (date == null) {
            throw new MissingDoctorRuntimeException("missing date!", new NullPointerException());
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

    @Override
    public void close() {
        System.out.println("Service is Closed!");
        totalAppointments = 0;
    }
}
