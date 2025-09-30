package com.solvd.hospitaltc.drug;

import java.util.Objects;

public class FluVaccine implements Vaccine {

    private String name;

    @Override
    public void vaccinate() {
        System.out.println("\nyou have been vaccinated from the flu" +
                "\ndon't do sports for 5 days");
    }

    @Override
    public int getVaccinationMinimalAge() {
        return VACCINATION_MINIMAL_AGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FluVaccine that = (FluVaccine) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

