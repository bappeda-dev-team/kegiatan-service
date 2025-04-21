package kk.kertaskerja.kegiatan_service.kegiatan.domain;

public class KegiatanAlreadyExistsException extends RuntimeException {
    public KegiatanAlreadyExistsException(String kodeKegiatan) {
        super("Kegiatan dengan kode " + kodeKegiatan + " sudah ada");
    }
}
