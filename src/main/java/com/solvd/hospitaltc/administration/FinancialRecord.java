package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.worker.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public record FinancialRecord(String code, LocalDateTime localDateTime, Human user) {

    private static final Logger logger = LogManager.getLogger(FinancialRecord.class);

    public FinancialRecord {
        if (code == null || user == null) {
            logger.warn("Not enough info for record");
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