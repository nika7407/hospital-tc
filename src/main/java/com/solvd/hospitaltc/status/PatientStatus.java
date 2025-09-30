package com.solvd.hospitaltc.status;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public enum PatientStatus {

    TO_BE_DISCHARGED(LocalDate.now(), "To be discharged"),
    UNDER_CARE(LocalDate.now(), "Under care"),
    FULL_TIME_MONITORING(LocalDate.now(), "Full time monitoring");

    private final LocalDate date;
    private final String description;

    private static final Map<String, PatientStatus> descriptionToStatus = new HashMap<>();

    static {
        for (PatientStatus status : values()) {
            descriptionToStatus.put(status.getDescription(), status);
        }
    }

    PatientStatus(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public static PatientStatus fromDescription(String description) {
        return descriptionToStatus.get(description);
    }

    @Override
    public String toString() {
        return name() + date + " " + description;
    }
}
