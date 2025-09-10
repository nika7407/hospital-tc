package hospital;

import hospital.administration.Appointment;
import hospital.administration.AppointmentService;
import hospital.administration.Hospital;
import hospital.building.Apparatus;
import hospital.building.Department;
import hospital.drug.DrugAssignmentService;
import hospital.drug.FluVaccine;
import hospital.drug.MeaslesVaccine;
import hospital.drug.Painkiller;
import hospital.drug.TestDrug;
import hospital.drug.Vaccine;
import hospital.guest.Guest;
import hospital.guest.HospitalGuest;
import hospital.guest.PatientVisitor;
import hospital.sertification.FirstHelpSertification;
import hospital.sertification.Sertificate;
import hospital.worker.CardiologySpetialazation;
import hospital.worker.Doctor;
import hospital.worker.Nurse;
import hospital.worker.Patient;
import hospital.worker.Spetialization;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        //initing departments
        Department cardiology = new Department(
                new Doctor[5],
                new Patient[50],
                new Nurse[15],
                new Apparatus[5],
                "Cardiology",
                30
        );

        Department surgery = new Department(
                new Doctor[8],
                new Patient[15],
                new Nurse[10],
                new Apparatus[3],
                "Surgery",
                20
        );

        Doctor doctor1 = new Doctor("luka", "tsintsadze",
                45, "lukatsi@yahoo.com", "cardiologist", 15);
        Doctor doctor2 = new Doctor("ana", "gogoberidze",
                38, "ana156@gmail.ge", "surgeon", 12);
        Doctor doctor3 = new Doctor("nikoloz", "javakhishvili",
                52, "javakhishvili145@hospital.ge", "cardiologist", 20);

        Patient patient1 = new Patient("nino", "tavadze", 32, "tavadze.@email.ru",
                "12345", LocalDateTime.now(), 3, false);
        Patient patient2 = new Patient("giorgi", "topuria", 35, "topuria@idk.com",
                "123456", LocalDateTime.now(), 7, true);
        Patient patient3 = new Patient("mariam", "chikovani", 23, "chikovani@email.ge",
                "1234567", LocalDateTime.now(), 5, false);
        Nurse nurse1 = new Nurse("tamar", "batsikadze",
                29, "batsikadze@idk.ge",
                5, true);
        Nurse nurse2 = new Nurse("vakhtang", "shatirishvili",
                35, "shatirishvili@kideRaMovifiqro.ge",
                8, false);


        // polymorphism, and assigning vaccine set
        Vaccine fluVaccine = new FluVaccine();
        Vaccine measlesVaccine = new MeaslesVaccine();
        Vaccine[] vaccineSet = new Vaccine[]{fluVaccine, measlesVaccine};
        patient1.setVaccines(vaccineSet);

        Spetialization cardiologySpetialazation = new CardiologySpetialazation();
        doctor3.setSpetialization(cardiologySpetialazation);

        Sertificate firstHelpCert = new FirstHelpSertification(LocalDateTime.now().plusDays(30));
        nurse2.setSertificate(firstHelpCert);

        PatientVisitor patientVisitor = new PatientVisitor(patient1,"someGuestId","kaxa",true);

        Painkiller painkiller = new Painkiller("noshpa",3);
        TestDrug testDrug = new TestDrug("experimentDrug","Do not use on blind children or deaf elders");

        //assigning drugs,
        DrugAssignmentService.assignDrug(painkiller,patient1);
        DrugAssignmentService.assignDrug(testDrug,patient2);

        Apparatus apparatus1 = new Apparatus("ekg", "heart scanner", false, cardiology);
        Apparatus apparatus2 = new Apparatus("mri", "mri scanner", true, surgery);

        //filling departments with people and such things
        cardiology.getDoctors()[0] = doctor1;
        cardiology.getDoctors()[1] = doctor3;
        cardiology.getPatients()[0] = patient1;
        cardiology.getPatients()[1] = patient3;
        cardiology.getNurses()[0] = nurse1;
        cardiology.getApparatus()[0] = apparatus1;

        surgery.getDoctors()[0] = doctor2;
        surgery.getPatients()[0] = patient2;
        surgery.getNurses()[0] = nurse2;
        surgery.getApparatus()[0] = apparatus2;

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
        Hospital hospital = new Hospital(
                "republic hospital",
                new Department[]{cardiology, surgery},
                new Appointment[]{appointment1, appointment2, appointment3}
        );

        //adding guests
        hospital.setGuests(new HospitalGuest[]{patientVisitor});
        System.out.println("\nHospital Class initiated!");
    }

}