package kk.kertaskerja.kegiatan_service.kegiatan.domain;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class KegiatanService {
    private final KegiatanRepository kegiatanRepository;
    public KegiatanService(KegiatanRepository kegiatanRepository) {
        this.kegiatanRepository = kegiatanRepository;
    }

    public Flux<Kegiatan> getAllKegiatans() {
        return kegiatanRepository.findAll();
    }
}
