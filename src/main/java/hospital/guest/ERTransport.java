package hospital.guest;

import hospital.worker.Doctor;
import hospital.worker.Human;

public class ERTransport<T extends Human> {

    private Doctor doctor;
    private T passenger;
    private String carNumber;

    public ERTransport(Doctor doctor, T passenger, String carNumber) {
        this.doctor = doctor;
        this.passenger = passenger;
        this.carNumber = carNumber;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public T getPassenger() {
        return passenger;
    }

    public void setPassenger(T passenger) {
        this.passenger = passenger;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void arrivedAtHospital() {
        System.out.println("The passenger: " + passenger.getFirstName() + " " + passenger.getLastName() + " is arrived");
        T passengerOutOfTheCar = passenger;
        passenger = null;
    }
}
