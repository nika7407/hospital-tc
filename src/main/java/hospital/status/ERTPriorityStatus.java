package hospital.status;

import java.util.HashMap;
import java.util.Map;

public enum ERTPriorityStatus {

    HIGH_PRIORITY("Indicates the highest level of urgency"),
    MIDDLE_PRIORITY("Indicates a moderate level of urgency"),
    LOW_PRIORITY("Indicates the lowest level of urgency");

    private final String description;

    private static final Map<String, ERTPriorityStatus> nameToPriority = new HashMap<>();

    static {
        for (ERTPriorityStatus priority : values()) {
            nameToPriority.put(priority.name().toLowerCase(), priority);
        }
    }

    ERTPriorityStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ERTPriorityStatus fromName(String name) {
        return nameToPriority.get(name.toLowerCase());
    }
}
