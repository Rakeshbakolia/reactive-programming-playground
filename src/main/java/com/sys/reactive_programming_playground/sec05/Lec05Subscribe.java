package com.sys.reactive_programming_playground.sec05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec05Subscribe {

    private static final Logger log = LoggerFactory.getLogger(Lec05Subscribe.class);


    public static void main(String[] args) {
        Flux.range(1,10)
                .doOnNext(i -> log.info("received : {}",i))
                .doOnError(throwable -> log.error("error ",throwable))
                .doOnComplete(() -> log.info("completed "))
                .subscribe();
    }
}
