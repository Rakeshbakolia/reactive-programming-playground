package com.sys.reactive_programming_playground.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    private static final Logger log = LoggerFactory.getLogger(Lec03MonoSubscribe.class);

    public static void main(String[] args) {
        var mono = Mono.just(1);
        mono.subscribe(i-> log.info("Received : {}", i),
                err -> log.error("Error", err),
                () -> log.info("Completed"),
                //optional auto request
                subscription -> subscription.request(1));
    }
}
