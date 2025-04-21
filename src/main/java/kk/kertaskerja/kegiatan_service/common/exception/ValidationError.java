package kk.kertaskerja.kegiatan_service.common.exception;

import java.time.Instant;

public record ValidationError(
        int status,
        String message,
        Object errors,
        Instant timestamp,
        String path
) {
}
