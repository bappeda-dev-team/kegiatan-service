package kk.kertaskerja.kegiatan_service.common;

import java.time.Instant;

public record HealthStatus(
        String status,
        Instant timestamp
) {
}
