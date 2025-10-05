package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.exception.MissingDateRuntimeException;
import com.solvd.hospitaltc.exception.MissingDoctorRuntimeException;
import com.solvd.hospitaltc.exception.MissingPatientRuntimeException;
import com.solvd.hospitaltc.worker.Doctor;
import com.solvd.hospitaltc.worker.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class AppointmentService implements AutoCloseable {

    private static int totalAppointments = 0;
    private static final Logger logger = LogManager.getLogger(AppointmentService.class);

    static {
        logger.info("Appointment Service started");
    }

    public static Appointment createAppointment(Patient patient, Doctor doctor, LocalDateTime date) {

        if (patient == null) {
            logger.error("MissingPatientRuntimeException(\"missing patient!\")");
            throw new MissingPatientRuntimeException("missing patient!");
        } else if (doctor == null) {
            logger.error("MissingDoctorRuntimeException(\"missing doctor!\")");
            throw new MissingDoctorRuntimeException("missing doctor!");
        } else if (date == null) {
            logger.error("MissingDateRuntimeException(\"missing date!\")");
            throw new MissingDateRuntimeException("missing date!");
        }

        Appointment appointment = new Appointment(patient, doctor, date, false);
        totalAppointments++;
        return appointment;
    }

    public static void completeAppointment(Appointment appointment) {
        if (appointment != null && !appointment.isFinished()) {
            appointment.setFinished(true);
            logger.info("Appointment completed for: {}", appointment.getPatient().getFirstName());
        }
    }

    @Override
    public void close() {
        logger.info("Service is Closed!");
        totalAppointments = 0;
    }
}
