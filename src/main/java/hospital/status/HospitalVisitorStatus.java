package hospital.status;

import java.util.HashMap;
import java.util.Map;

public enum HospitalVisitorStatus {

    VISITING("Currently visiting the hospital"),
    FINISHED_VISITING("Visit to the hospital is completed");

    private final String description;

    private static final Map<String, HospitalVisitorStatus> nameToStatus = new HashMap<>();

    static {
        for (HospitalVisitorStatus status : values()) {
            nameToStatus.put(status.name().toLowerCase(), status);
        }
    }

    HospitalVisitorStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static HospitalVisitorStatus fromName(String name) {
        return nameToStatus.get(name.toLowerCase());
    }
}
