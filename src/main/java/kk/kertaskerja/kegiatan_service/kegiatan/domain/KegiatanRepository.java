package kk.kertaskerja.kegiatan_service.kegiatan.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface KegiatanRepository extends ReactiveCrudRepository<Kegiatan, Long> {
    Mono<Boolean> existsByKodeKegiatan(String kodeKegiatan);
    Mono<Kegiatan> findByKodeKegiatan(String kodeKegiatan);
}
