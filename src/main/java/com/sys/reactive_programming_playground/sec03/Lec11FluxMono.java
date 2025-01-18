package com.sys.reactive_programming_playground.sec03;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec11FluxMono {

    public static void main(String[] args) {
        var flux = Flux.range(1,10);
//      flux to mono
        flux.next().subscribe(Util.subscriber());
//      another way
        Mono.from(flux).subscribe(Util.subscriber());
    }

    private static void monoToFLux(){
        var mono = getUserName(3);
        save(Flux.from(mono));
    }

    private static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("User1");
            case 2 -> Mono.empty(); // null
            default -> Mono.error(new RuntimeException("Invalid input"));
        };
    }

    private static void save(Flux<String> flux){
        flux.subscribe(Util.subscriber());
    }
}
