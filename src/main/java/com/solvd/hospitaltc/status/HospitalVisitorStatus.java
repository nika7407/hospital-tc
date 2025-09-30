package com.solvd.hospitaltc.status;

public enum HospitalVisitorStatus {

    VISITING("Currently visiting the hospital"),
    FINISHED_VISITING("Visit to the hospital is completed");

    private final String description;

    HospitalVisitorStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static HospitalVisitorStatus fromName(String name) {
        if (name == null) {
            return null;
        }

        for (HospitalVisitorStatus status : values()) {
            if (status.name().equals(name)) {
                return status;
            }
        }
        return null;
    }
}
