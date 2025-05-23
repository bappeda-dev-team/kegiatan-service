package kk.kertaskerja.kegiatan_service.kegiatan.domain;

import kk.kertaskerja.kegiatan_service.program.ProgramClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class KegiatanService {
    private final ProgramClient programClient;
    private final KegiatanRepository kegiatanRepository;
    public KegiatanService(ProgramClient programClient,KegiatanRepository kegiatanRepository) {
        this.programClient = programClient;
        this.kegiatanRepository = kegiatanRepository;
    }

    public Flux<Kegiatan> getAllKegiatans() {
        return kegiatanRepository.findAll();
    }

    public Mono<Kegiatan> getByKodeKegiatan(String kodeKegiatan) {
        return kegiatanRepository.findByKodeKegiatan(kodeKegiatan)
                .switchIfEmpty(Mono.error(new KegiatanNotFoundException(kodeKegiatan)));
    }

    public Mono<Kegiatan> addKegiatan(String kodeProgram, String kodeKegiatan, String namaKegiatan) {
        return kegiatanRepository.existsByKodeKegiatan(kodeKegiatan)
                .flatMap(exists -> {
                    if (exists) return Mono.error(new KegiatanAlreadyExistsException(kodeKegiatan));
                    return programClient.getByKodeProgram(kodeProgram)
                            .map(prg -> buildKegiatanValid(kodeKegiatan, namaKegiatan))
                            .defaultIfEmpty(buildKegiatanTidakValid(kodeKegiatan, namaKegiatan));
                })
                .flatMap(kegiatanRepository::save);
    }

    public static Kegiatan buildKegiatanValid(String kodeKegiatan, String namaKegiatan) {
        return Kegiatan.of(kodeKegiatan, namaKegiatan, KegiatanStatus.VALID);
    }

    public static Kegiatan buildKegiatanTidakValid(String kodeKegiatan, String namaKegiatan) {
        return Kegiatan.of(kodeKegiatan, namaKegiatan, KegiatanStatus.TIDAK_VALID);
    }
}
