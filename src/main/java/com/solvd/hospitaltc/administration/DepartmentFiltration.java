package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.worker.Doctor;
import com.solvd.hospitaltc.worker.Human;
import com.solvd.hospitaltc.worker.Patient;
import com.solvd.hospitaltc.worker.Spetialization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DepartmentFiltration {

    private static final Logger logger = LogManager.getLogger(DepartmentFiltration.class);

    public static List<Patient> filterPatientsAndReport(List<Patient> patients,
                                                        Predicate<Patient> predicate) {

        List<Patient> filteredPatients = patients.stream()
                .filter(predicate)
                .peek(patient ->
                        logger.info("{} {}", patient.getFirstName(), patient.getLastName()))
                .collect(Collectors.toList());

        logger.info("total filtered patients: {}", filteredPatients.size());

        return filteredPatients;
    }

    public static Map<String, Spetialization> mapDoctors(List<Doctor> doctors) {

        Map<String, Spetialization> result = doctors.stream()
                .filter(doctor -> doctor.getSpetialization() != null)
                .collect(Collectors.toMap(
                        Doctor::getLastName,
                        Doctor::getSpetialization
                ));

        logger.info("Doctors mapped to their Specialisations!");
        return result;
    }

    public static int countExpiriencedDoctors(List<Doctor> doctors) {
        return (int) doctors.stream()
                .filter(doctor -> doctor.getExpirienceYears() > 4)
                .count();
    }

    public static List<String> getAllFullNames(List<? extends Human> people) {
        return people.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toList());
    }

    public static <T> List<T> flattenList(List<List<T>> notFlatList) {
        return notFlatList.stream()
                .flatMap(List::stream)
                .toList();
    }
}
