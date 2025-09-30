package com.solvd.hospitaltc.drug;

public interface Vaccine {

    int VACCINATION_MINIMAL_AGE = 14;

    void vaccinate();

    int getVaccinationMinimalAge();

}
