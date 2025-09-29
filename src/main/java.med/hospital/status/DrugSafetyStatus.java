package hospital.status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum DrugSafetyStatus {

    SAFE_FOR_CHILDREN,
    SAFE_FOR_ADULTS,
    NOT_SAFE;

    private static final Map<String, DrugSafetyStatus> nameToStatus = new HashMap<>();

    static {
        Arrays.stream(DrugSafetyStatus.values())
                .forEach(status -> nameToStatus.put(status.name().toLowerCase(), status));
    }

    public static DrugSafetyStatus fromName(String name) {
        return nameToStatus.get(name.toLowerCase());
    }

    public boolean isSafe() {
        return this != NOT_SAFE;
    }

    public String getWarning() {
        return this == NOT_SAFE ? "Warning: Not safe for use" : "Safe for administration";
    }

    @Override
    public String toString() {
        return name().toLowerCase().replace('_', ' ');
    }
}