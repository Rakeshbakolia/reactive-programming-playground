package com.sys.reactive_programming_playground.sec05;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Lec09Timeout {

    public static void main(String[] args) {
        var mono = getProductName()
                .timeout(Duration.ofSeconds(1), fallback1());

        mono
                .timeout(Duration.ofSeconds(2), fallback2())
                .subscribe(Util.subscriber());

        Util.sleepSecond(10);
    }

    private static Mono<String> getProductName(){
        return Mono.fromSupplier(() -> "service 1 - " + Util.faker().commerce().productName())
                .delayElement(Duration.ofSeconds(3));
    }

    private static Mono<String> fallback1(){
        return Mono.fromSupplier(() -> "service 2 - " + Util.faker().commerce().productName())
                .delayElement(Duration.ofMillis(1900));
    }

    private static Mono<String> fallback2(){
        return Mono.fromSupplier(() -> "service 3 - " + Util.faker().commerce().productName())
                .delayElement(Duration.ofMillis(900));
    }
}
