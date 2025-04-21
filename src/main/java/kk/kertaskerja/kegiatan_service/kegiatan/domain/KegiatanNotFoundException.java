package kk.kertaskerja.kegiatan_service.kegiatan.domain;

public class KegiatanNotFoundException extends RuntimeException {
    public KegiatanNotFoundException(String kodeKegiatan) {
        super("Kegiatan dengan kode " + kodeKegiatan + " tidak ditemukan");
    }
}
