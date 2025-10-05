package com.solvd.hospitaltc.sertification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public final class FirstHelpCertification implements Certificate {

    private static final Logger log = LogManager.getLogger(FirstHelpCertification.class);
    private LocalDateTime expiresAt;

    public FirstHelpCertification(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDate expiresAt) {
        this.expiresAt = expiresAt.atStartOfDay();
    }

    @Override
    public void showCertification() {
        log.info("this user is certified to do first help!");
    }

    @Override
    public boolean isCertificateExpired() {

        return java.time.LocalDate.now().isBefore(ChronoLocalDate.from(expiresAt));
    }
}
