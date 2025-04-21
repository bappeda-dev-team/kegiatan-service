package kk.kertaskerja.kegiatan_service;

import org.springframework.boot.SpringApplication;

public class TestKegiatanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(KegiatanServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
