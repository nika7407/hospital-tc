package hospital.sertification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public final class FirstHelpSertification implements Sertificate {

    private LocalDateTime expiresAt;

    public FirstHelpSertification(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDate expiresAt) {
        this.expiresAt = expiresAt.atStartOfDay();
    }

    @Override
    public void showSertification() {
        System.out.println("this user is certified to do first help!");
    }

    @Override
    public boolean isSertificateExpired() {

        return java.time.LocalDate.now().isBefore(ChronoLocalDate.from(expiresAt));
    }
}
