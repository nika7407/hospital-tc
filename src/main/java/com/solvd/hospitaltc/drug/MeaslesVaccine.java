package com.solvd.hospitaltc.drug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class MeaslesVaccine implements Vaccine {

    private final static int daysOfNotDrinking = 3;
    private static final Logger log = LogManager.getLogger(MeaslesVaccine.class);
    private String name;

    @Override
    public void vaccinate() {
        log.info("you have been vaccinated by: measles vaccine" +
                "dont drink for " + daysOfNotDrinking + " days");
    }

    @Override
    public int getVaccinationMinimalAge() {
        return VACCINATION_MINIMAL_AGE;
    }

    public static void isVaccineHarmful() {
        log.info("no the vaccine is not harmful!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeaslesVaccine that = (MeaslesVaccine) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
