package kk.kertaskerja.kegiatan_service.common.exception;

import java.time.Instant;

public record ApiError(
        int status,
        String message,
        Instant timestamp,
        String path
) {
}
