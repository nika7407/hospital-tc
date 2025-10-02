package com.solvd.hospitaltc;

import com.solvd.hospitaltc.administration.Appointment;
import com.solvd.hospitaltc.administration.AppointmentService;
import com.solvd.hospitaltc.administration.ContaminationCheck;
import com.solvd.hospitaltc.administration.DepartmentFiltration;
import com.solvd.hospitaltc.administration.EmailRegistration;
import com.solvd.hospitaltc.administration.FinancialRecord;
import com.solvd.hospitaltc.administration.Hospital;
import com.solvd.hospitaltc.administration.PatientCheckup;
import com.solvd.hospitaltc.administration.PatientRegistration;
import com.solvd.hospitaltc.administration.PatientToReport;
import com.solvd.hospitaltc.administration.VaccinationBooth;
import com.solvd.hospitaltc.administration.VaccinationProcedure;
import com.solvd.hospitaltc.building.Apparatus;
import com.solvd.hospitaltc.building.Department;
import com.solvd.hospitaltc.drug.Drug;
import com.solvd.hospitaltc.drug.DrugAssignmentService;
import com.solvd.hospitaltc.drug.DrugDelivery;
import com.solvd.hospitaltc.drug.DrugGenerator;
import com.solvd.hospitaltc.drug.DrugRegistration;
import com.solvd.hospitaltc.drug.FluVaccine;
import com.solvd.hospitaltc.drug.MeaslesVaccine;
import com.solvd.hospitaltc.drug.Painkiller;
import com.solvd.hospitaltc.drug.TestDrug;
import com.solvd.hospitaltc.drug.Vaccine;
import com.solvd.hospitaltc.exception.CheckupException;
import com.solvd.hospitaltc.exception.WrongEmailException;
import com.solvd.hospitaltc.guest.ERTransport;
import com.solvd.hospitaltc.guest.HospitalGuest;
import com.solvd.hospitaltc.guest.PatientVisitor;
import com.solvd.hospitaltc.lambda.NurseCertificateRegistration;
import com.solvd.hospitaltc.lambda.Registration;
import com.solvd.hospitaltc.lambda.Report;
import com.solvd.hospitaltc.sertification.Certificate;
import com.solvd.hospitaltc.sertification.CertificateRegistration;
import com.solvd.hospitaltc.sertification.FirstHelpCertification;
import com.solvd.hospitaltc.status.DrugSafetyStatus;
import com.solvd.hospitaltc.status.ERTPriorityStatus;
import com.solvd.hospitaltc.status.HospitalVisitorStatus;
import com.solvd.hospitaltc.status.PatientIllness;
import com.solvd.hospitaltc.status.PatientStatus;
import com.solvd.hospitaltc.util.ReflectionMaker;
import com.solvd.hospitaltc.util.TextBookUtil;
import com.solvd.hospitaltc.worker.CardiologySpecialization;
import com.solvd.hospitaltc.worker.Doctor;
import com.solvd.hospitaltc.worker.Nurse;
import com.solvd.hospitaltc.worker.Patient;
import com.solvd.hospitaltc.worker.Spetialization;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class Main {

    public static void main(String[] args) throws Exception {

        //initing departments
        Map<Patient, String> cardiologyNotes = new HashMap<>();
        Map<Patient, String> surgeryNotes = new HashMap<>();
        Department cardiology = new Department(
                new ArrayList<>(),
                new HashSet<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                "Cardiology",
                30,
                cardiologyNotes
        );

        Department surgery = new Department(
                new ArrayList<>(),
                new HashSet<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                "Surgery",
                20,
                surgeryNotes
        );

        Doctor doctor1 = new Doctor("luka", "tsintsadze",
                45, "lukatsi@yahoo.com", "cardiologist", 15);
        Doctor doctor2 = new Doctor("ana", "gogoberidze",
                38, "ana156@gmail.ge", "surgeon", 12);
        Doctor doctor3 = new Doctor("nikoloz", "javakhishvili",
                52, "javakhishvili145@hospital.ge", "cardiologist", 20);

        Patient patient1 = new Patient("nino", "tavadze", 32, "tavadze.@email.ru",
                "12345", LocalDateTime.now(), 3, false);
        Patient patient2 = new Patient("giorgi", "kitia", 35, "kitia@idk.com",
                "123456", LocalDateTime.now(), 7, true);
        Patient patient3 = new Patient("mariam", "chikovani", 23, "chikovani@email.ge",
                "1234567", LocalDateTime.now(), 5, false);
        Patient patient4 = new Patient("zuka", "kintiraia", 45, "zuka@gmail.ge",
                "041241", LocalDateTime.now(), 2, false);
        Patient patient5 = new Patient("mari", "kikaleishvili", 99, "mariiii@gmail.ge",
                "897742", LocalDateTime.now(), 8, false);

        //annotated
        System.out.println("\n" + patient2.toString());

        Nurse nurse1 = new Nurse("tamar", "batsikadze",
                29, "batsikadze@idk.ge",
                5, true);
        Nurse nurse2 = new Nurse("vakhtang", "shatirishvili",
                35, "shatirishvili@kideRaMovifiqro.ge",
                8, false);

        patient1.setPatientStatus(PatientStatus.UNDER_CARE);
        patient2.setPatientIllness(PatientIllness.FLU);

        try (EmailRegistration emailRegistration = new EmailRegistration(patient1)) {
            emailRegistration.registerEmail();
        } catch (WrongEmailException e) {
            System.out.println("incorrect email!");
        } catch (Exception e) {
            System.out.println("Unknown Problem!");
        }

        // polymorphism, and assigning vaccine sets
        Vaccine fluVaccine = new FluVaccine();
        Vaccine measlesVaccine = new MeaslesVaccine();

        VaccinationBooth.checkForTheVaccination(fluVaccine, patient1);
        VaccinationBooth.checkForTheVaccination(measlesVaccine, patient1);

        Spetialization cardiologySpetialazation = new CardiologySpecialization();
        doctor3.setSpetialization(cardiologySpetialazation);

        Certificate firstHelpCert = new FirstHelpCertification(LocalDateTime.now().plusDays(30));
        nurse2.setSertificate(firstHelpCert);

        PatientCheckup patientCheckup = new PatientCheckup();
        try {
            patientCheckup.checkup(patient1);
        } catch (CheckupException e) {
            System.out.println("\n" + e.getMessage());
        } finally {
            System.out.println("Try again!");
        }

        Painkiller painkiller = new Painkiller("noshpa", 3);
        painkiller.setSafetyStatus(DrugSafetyStatus.SAFE_FOR_CHILDREN);
        TestDrug testDrug = new TestDrug("experimentDrug", "Do not use on blind children or deaf elders");

        //assigning drugs,
        DrugAssignmentService.assignDrug(painkiller, patient1);
        DrugAssignmentService.assignDrug(testDrug, patient2);

        Apparatus apparatus1 = new Apparatus("ekg", "heart scanner", false, cardiology);
        Apparatus apparatus2 = new Apparatus("mri", "mri scanner", true, surgery);

        //filling departments with people and such things
        cardiology.getDoctors().add(doctor1);
        cardiology.getDoctors().add(doctor3);
        cardiology.getPatients().add(patient1);
        cardiology.getPatients().add(patient3);
        cardiology.getPatients().add(patient4);
        cardiology.getPatients().add(patient5);
        cardiology.getNurses().add(nurse1);
        cardiology.getApparatus().add(new Apparatus("ekg", "heart scanner", false, cardiology));
        cardiology.getPatientNotes().put(patient1, "Needs regular EKG");
        cardiology.getPatientNotes().put(patient3, "Monitor blood pressure");

        surgery.getDoctors().add(doctor2);
        surgery.getPatients().add(patient2);
        surgery.getNurses().add(nurse2);
        surgery.getApparatus().add(new Apparatus("mri", "mri scanner", true, surgery));
        surgery.getPatientNotes().put(patient2, "Post-op observation");

        //static method to create appointments
        Appointment appointment1 = AppointmentService.createAppointment(
                patient1, doctor1, LocalDateTime.now().plusDays(1));
        Appointment appointment2 = AppointmentService.createAppointment(
                patient2, doctor2, LocalDateTime.now().plusDays(5));
        Appointment appointment3 = AppointmentService.createAppointment(
                patient3, doctor3, LocalDateTime.now());

        AppointmentService.completeAppointment(appointment1);
        AppointmentService.completeAppointment(appointment3);

        // Main hospital class
        Map<String, Department> departments = new HashMap<>();
        departments.put(cardiology.getName(), cardiology);
        departments.put(surgery.getName(), surgery);
        List<Appointment> appointmentList = Arrays.asList(appointment1, appointment2, appointment3);
        Hospital hospital = new Hospital(
                "republic hospital",
                departments,
                appointmentList
        );

        //adding guests
        Set<HospitalGuest> guests = new HashSet<>();
        PatientVisitor patientVisitor3 = new PatientVisitor(patient1, "someGuestId", "kaxa", true);
        patientVisitor3.setStatus(HospitalVisitorStatus.VISITING);
        hospital.setGuests(guests);
        System.out.println("\nHospital Class initiated!");

        //emergency responce transport
        ERTransport<Patient> erCar = new ERTransport<>(doctor1, patient2, "car42");
        erCar.setErtPriority(ERTPriorityStatus.HIGH_PRIORITY);

        Runnable arrival = () -> {
            System.out.println("The passenger arrived!");
        };

        erCar.arrivedAtHospital(arrival);

        DrugDelivery<Painkiller> drugDelivery = new DrugDelivery<>("DrugOnTime");
        drugDelivery.setDrugToDeliver(painkiller);

        Consumer<Drug> drugArrival = d -> {
            if (d == null) {
                System.out.println("there's no drugs to deliver");
            }
            System.out.println("\nDrug: " + d.getName() + " is delivered");
            d = null;
        };

        drugDelivery.deliverDrug(drugArrival);

        // list
        System.out.println("\ndoctors:");
        List<Doctor> docList = cardiology.getDoctors();
        Map<String, Spetialization> doctorMap = DepartmentFiltration.mapDoctors(docList);

        System.out.println("\nAmount of expirienced Doctors:"
                + DepartmentFiltration.countExpiriencedDoctors(docList));

        List<String> fullNames = DepartmentFiltration.getAllFullNames(docList);

        System.out.println("senior doctor: " + docList.getFirst().getLastName());

        docList.stream()
                .filter(doctor -> doctor.getExpirienceYears() < 1)
                .forEach(doctor -> System.out.println(doctor.getFirstName() + " " + doctor.getLastName()));


        System.out.println("total " + cardiology.getDoctors().size());

        // set
        System.out.println("\npatients in cardiology");
        Set<Patient> patientSet = cardiology.getPatients();

        patientSet.stream()
                .findFirst()
                .ifPresent(firstPatient -> System.out.println("first patient: " + firstPatient.getFirstName() + " " + firstPatient.getLastName()));

        for (Patient p : cardiology.getPatients()) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }

        System.out.println("total " + cardiology.getPatients().size());

        if (cardiology.getPatients().isEmpty()) {
            System.out.println("cardiology is empty!");
        }

        // map demo
        System.out.println("\npatient notes");
        Map<Patient, String> notesMap = cardiology.getPatientNotes();
        if (!notesMap.isEmpty()) {
            Map.Entry<Patient, String> firstEntry = notesMap.entrySet().iterator().next();
            System.out.println("first note: " + firstEntry.getKey().getFirstName() + " - " + firstEntry.getValue());
        }
        for (Map.Entry<Patient, String> entry : notesMap.entrySet()) {
            System.out.println(entry.getKey().getFirstName() + " " + entry.getValue());

        }

        // records
        FinancialRecord financialRecord1 = new FinancialRecord("123", doctor1);
        hospital.addRecords(financialRecord1);

        //lambdas
        ToIntFunction<Patient> diffReCheck = (pat) -> {
            int assignedDrugsAmount = pat.getAssignedDrugs().size();

            if (assignedDrugsAmount > 2) {
                return pat.getDifficultyScale() + 1;
            } else {
                return pat.getDifficultyScale();
            }
        };
        DrugAssignmentService.difficultyCheck(patient3, diffReCheck);

        Supplier<Drug> defaultDrug = () -> {
            return new Drug("defaultDrug");
        };
        DrugGenerator.generate(defaultDrug);

        Predicate<Patient> vaccinationNeeded = patient -> {
            return !patient.getVaccines().isEmpty();
        };

        VaccinationProcedure.testForVaccine(patientSet, vaccinationNeeded);

        //checking the more difficult patient
        BinaryOperator<Patient> checkDifficulty = (pat1, pat2) -> {
            int difficulty1 = pat1.getDifficultyScale();
            int difficulty2 = pat2.getDifficultyScale();
            if (difficulty1 > difficulty2 || difficulty1 == difficulty2) {
                return pat1;
            } else {
                return pat2;
            }
        };

        System.out.println("\n" + checkDifficulty.apply(patient1, patient2).getLastName()
                + " is more difficult and needs help!");

        DrugRegistration drugRegistration = new DrugRegistration();
        Drug aspirin = new Drug("nurofen");
        drugRegistration.registerDrug(aspirin, d -> System.out.println("registering " + d.getName()));
        if (drugRegistration.isRegistered(aspirin)) {
            System.out.println("nurofen is registered!");
        }

        Registration patientRegistration = () -> new Patient(
                "Default",
                "Patient",
                0,
                "default@email.com",
                "0000",
                LocalDateTime.now(),
                0,
                false
        );

        NurseCertificateRegistration certificateRegistration = (nurs, cert) -> {
            if (nurs.getSertificate() == null) {
                nurs.setSertificate(cert);
            }
        };

        CertificateRegistration.nurseCertification(nurse2, firstHelpCert, certificateRegistration);

        Report report = pat -> {
            System.out.println("\npatient report: " + pat.getFirstName() + " " + pat.getLastName() + ", age: " + pat.getAge());
        };

        Predicate<Patient> filter = patient -> patient.getDifficultyScale() < 5;
        DepartmentFiltration.filterPatientsAndReport(cardiology.getPatients().stream().toList(), filter);

        Patient defaulPatient = PatientRegistration.register(patientRegistration);
        PatientToReport.report(defaulPatient, report);

        List<Patient> patientListCardiology = cardiology.getPatients()
                .stream()
                .toList();
        List<Patient> patientListSurgery = surgery.getPatients()
                .stream()
                .toList();

        List<List<Patient>> patientLists = new ArrayList<>(List.of(patientListCardiology, patientListSurgery));

        System.out.println(DepartmentFiltration.flattenList(patientLists));
        //refl
        ReflectionMaker.analyzeReflect(doctor1);
        ReflectionMaker.createDoctorWithReflection(doctor1);

        ContaminationCheck.Check(patientVisitor3);
        ContaminationCheck.Check(doctor1);

        File book = new File("src/main/resources/Medical Systems In The Digital age.txt");
        TextBookUtil.CountUniqueWords(book);
    }
}