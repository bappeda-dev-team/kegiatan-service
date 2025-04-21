package kk.kertaskerja.kegiatan_service.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(prefix = "kertaskerja.client")
public record ClientProperties(
        @NotNull
        URI programServiceUri
) {
}
