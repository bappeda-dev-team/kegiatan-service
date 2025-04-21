package kk.kertaskerja.kegiatan_service.kegiatan.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record KegiatanRequest(
        @NotBlank(message = "Kode program wajib terisi")
        String kodeProgram,

        @NotBlank(message = "Kode kegiatan wajib terisi")
        @Pattern(
                regexp = "^([A-Z]|\\d)\\.([A-Z]{2}|\\d{2})\\.(\\d{2})\\.(\\d)\\.(\\d{2})$",
                message = "Format kode tidak valid"
        )
        String kodeKegiatan,

        @NotBlank(message = "Nama kegiatan wajib terisi")
        String namaKegiatan
) {
}
