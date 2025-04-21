package kk.kertaskerja.kegiatan_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kertaskerja")
public record KertasKerjaProperties(
        String status
) {
}
