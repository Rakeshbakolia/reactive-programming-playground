package com.sys.reactive_programming_playground.sec05;

import com.sys.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06ErrorHandling {

    private static final Logger log = LoggerFactory.getLogger(Lec06ErrorHandling.class);

    public static void main(String[] args) {
        Flux.range(1,10)
                .map(i -> i == 5 ? 5/0 : i)
//                .onErrorResume(ex -> fallback())
                .onErrorResume(ArithmeticException.class, ex -> fallback1())
                .onErrorResume(ex -> fallback2())
                .onErrorReturn(-5)
//              complete in case of error
                .onErrorContinue((ex, o) -> log.error("===> {}", o, ex))
                .onErrorComplete()
                .subscribe(Util.subscriber());
    }

    private static void onErrorReturn(){
        Mono.just(5)
                .map(i -> i == 5 ? 5/0 : i)
                .onErrorReturn(IllegalAccessException.class, -1)
                .onErrorReturn(ArithmeticException.class, -2)
                .subscribe(Util.subscriber());
    }


    private static Mono<Integer> fallback1(){
        return Mono.fromSupplier(() ->Util.faker().random().nextInt(10,100));
    }

    private static Mono<Integer> fallback2(){
//        throw new RuntimeException();
        return Mono.fromSupplier(() ->Util.faker().random().nextInt(100,1000));
    }

}
