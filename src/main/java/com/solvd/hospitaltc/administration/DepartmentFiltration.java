package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.worker.Doctor;
import com.solvd.hospitaltc.worker.Human;
import com.solvd.hospitaltc.worker.Patient;
import com.solvd.hospitaltc.worker.Spetialization;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DepartmentFiltration {

    public static List<Patient> filterPatientsAndReport(List<Patient> patients,
                                                        Predicate<Patient> predicate) {
        System.out.println("\n");
        List<Patient> filteredPatients = patients.stream()
                .filter(predicate)
                .peek(patient ->
                        System.out.println(patient.getFirstName() + " " + patient.getLastName()))
                .collect(Collectors.toList());

        System.out.println("Total filtered patients: " + filteredPatients.size());

        return filteredPatients;
    }

    public static Map<String, Spetialization> mapDoctors(List<Doctor> doctors) {

        Map<String, Spetialization> result = doctors.stream()
                .filter(doctor -> doctor.getSpetialization() != null)
                .collect(Collectors.toMap(
                        Doctor::getLastName,
                        Doctor::getSpetialization
                ));

        System.out.println("\nDoctors mapped to their Specialisations!");
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
