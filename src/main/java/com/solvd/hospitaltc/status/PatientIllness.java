package com.solvd.hospitaltc.status;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public enum PatientIllness {

    FLU(LocalDate.now(), "flu"),
    SYPHILIS(LocalDate.now(), "syphilis"),
    HIV(LocalDate.now(), "hiv");

    private final LocalDate date;
    private final String description;

    private static final Map<String, PatientIllness> descriptionToIlness = new HashMap<>();

    static {
        for (PatientIllness ilness : values()) {
            descriptionToIlness.put(ilness.getDescription(), ilness);
        }
    }

    PatientIllness(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public static PatientIllness fromDescription(String description) {
        return descriptionToIlness.get(description);
    }

    @Override
    public String toString() {
        return name() + " (" + date + ": " + description + ")";
    }
}
