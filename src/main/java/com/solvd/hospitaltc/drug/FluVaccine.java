package com.solvd.hospitaltc.drug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class FluVaccine implements Vaccine {

    private static final Logger log = LogManager.getLogger(FluVaccine.class);
    private String name;

    @Override
    public void vaccinate() {
        log.info("\nyou have been vaccinated from the flu" +
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

