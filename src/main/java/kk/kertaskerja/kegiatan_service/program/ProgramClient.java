package kk.kertaskerja.kegiatan_service.program;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Component
public class ProgramClient {
    private static final String PROGRAM_ROOT_API = "/program/";
    private final WebClient webClient;

    public ProgramClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Program> getByKodeProgram(String kodeProgram) {
        return webClient.get()
                .uri(PROGRAM_ROOT_API + kodeProgram)
                .retrieve()
                .bodyToMono(Program.class)
                .timeout(Duration.ofSeconds(3), Mono.empty())
                .onErrorResume(WebClientResponseException.NotFound.class,
                        ex -> Mono.empty())
                .retryWhen(Retry.backoff(3, Duration.ofMillis(100)))
                .onErrorResume(Exception.class, ex -> Mono.empty());
    }
}
