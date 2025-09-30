package hospital.administration;

import hospital.worker.Human;

import java.time.LocalDateTime;

public record FinancialRecord(String code, LocalDateTime localDateTime, Human user) {

    public FinancialRecord {
        if (code == null || user == null) {
            System.out.println("Not enough info for record");
        }
        if (localDateTime == null) {
            localDateTime = LocalDateTime.now();
        }
    }

    public FinancialRecord(String code, Human user) {
        this(code, LocalDateTime.now(), user);
    }

    public boolean isValid() {
        return code != null && !code.isBlank() && user != null;
    }

    public String getFormattedTimestamp() {
        return localDateTime.toString().replace('T', ' ');
    }
}