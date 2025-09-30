package com.solvd.hospitaltc.sertification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public final class FirstHelpCertification implements Certificate {

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
        System.out.println("this user is certified to do first help!");
    }

    @Override
    public boolean isCertificateExpired() {

        return java.time.LocalDate.now().isBefore(ChronoLocalDate.from(expiresAt));
    }
}
