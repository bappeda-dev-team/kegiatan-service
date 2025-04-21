package kk.kertaskerja.kegiatan_service.kegiatan.web;

import jakarta.validation.Valid;
import kk.kertaskerja.kegiatan_service.kegiatan.domain.Kegiatan;
import kk.kertaskerja.kegiatan_service.kegiatan.domain.KegiatanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("kegiatan")
public class KegiatanController {
    private final KegiatanService kegiatanService;
    public KegiatanController(KegiatanService kegiatanService) {
        this.kegiatanService = kegiatanService;
    }

    @GetMapping
    public Flux<Kegiatan> getAllKegiatans() {
        return kegiatanService.getAllKegiatans();
    }

    @GetMapping("{kodeKegiatan}")
    public Mono<Kegiatan> getByKodeKegiatan(@PathVariable String kodeKegiatan) {
        return kegiatanService.getByKodeKegiatan(kodeKegiatan);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Kegiatan> addKegiatan(@RequestBody @Valid KegiatanRequest request) {
        return kegiatanService.addKegiatan(request.kodeProgram(),
                request.kodeKegiatan(),
                request.namaKegiatan());
    }

}
