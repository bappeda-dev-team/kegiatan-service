package kk.kertaskerja.kegiatan_service.kegiatan.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

public record Kegiatan(
        @Id Long id,
        String kodeKegiatan,
        String namaKegiatan,
        KegiatanStatus status,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int version
) {
    public static Kegiatan of(String kodeKegiatan, String namaKegiatan, KegiatanStatus status) {
        return new Kegiatan(null, kodeKegiatan, namaKegiatan, status, null, null, 0);
    }
}
